package study.day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class Ex1OracleShop {
	static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
//	static final String ORACLE_URL = "jdbc:oracle:thin:@192.168.0.24:1521:xe"; // 강사 pc 연결
	
	Ex1OracleShop() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("오라클 드라이버 실패: " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(ORACLE_URL, "angel", "a1234");
			System.out.println("로컬 오라클 연결 성공");
		} catch (SQLException e) {
			System.out.println("로컬 오라클 연결 실패" + e.getMessage());
		}
		
		return conn;
	}
	
	public void writeShop() {
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from shop order by num";
		
		try {
			stmt = conn.createStatement();
			// 데이터를 가져오는 select 문은 무조건 excuteQuery() 로 sql문을 실행한다
			rs = stmt.executeQuery(sql);
			
			// rs.next() 는 다음 레코드로 이동, 다음 데이터가 있으면 true 없으면 false
			while(rs.next()) {
				int num = rs.getInt(1); // 컬럼번호로 가져와도되고 컬럼명으로 가져와도된다
				String sangpum = rs.getString(2);
				
				int su = rs.getInt("su");
				int dan = rs.getInt("dan");
				String color = rs.getString("color");
//				String today = rs.getString("today");
				Timestamp today = rs.getTimestamp("today");
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm"); // H: 24시간
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd a hh:mm"); // a: am/pm, h: 12시간
				
				System.out.println(num + "\t" + sangpum + "\t" + su + "\t" + dan + "\t" + color + "\t" + dateFormat.format(today));
			}
		} catch (SQLException e) {
			System.out.println("sql 오류: " + e.getMessage());
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException e) {
				
			}
		}
	}
	
	
	private void searchSangpum(String sang) {
		String sql = "select * from shop where instr(sangpum, '" + sang + "') > 0";
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			System.out.println("\"" + sang + "\" 검색결과");
			while(rs.next()) {
				Timestamp ts = rs.getTimestamp("today");
				System.out.println("=".repeat(40));
				System.out.println("번호: " + rs.getInt("num"));
				System.out.println("상품명: " + rs.getString("sangpum"));
				System.out.println("수량: " + rs.getInt("su"));
				System.out.println("가격: " + rs.getInt("dan"));
				System.out.println("날짜: " + new SimpleDateFormat("yyyy-MM-dd").format(ts));
				System.out.println("색상: " + rs.getString("color"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException e) {}
		}
		
	}
	private int searchCount(String sang) {
		String sql = "select count(sangpum) from shop where instr(sangpum, '" + sang + "') > 0";
		Connection conn = this.getConnection();
		Statement stmt = null;
		ResultSet rs = null;
		int cnt = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				cnt = rs.getInt(1); // 열번호로 값 가져오기
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException e) {}
		}
		return cnt;
	}
	public static void main(String[] args) {
		Ex1OracleShop ex1 = new Ex1OracleShop();
		ex1.writeShop();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("검색할 상품명을 입력해주세요(종료: exit");
			String sang = sc.nextLine();
			if(sang.equalsIgnoreCase("exit")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			int totalCount = ex1.searchCount(sang);
			if(totalCount == 0) {
				System.out.println(sang + " 상품은 없습니다");
				continue; // while문 처음으로
			} else{
				ex1.searchSangpum(sang);				
			}
		}
		sc.close();
		
	}



}	
