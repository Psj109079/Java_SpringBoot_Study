package study.day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Ex3MysqlBit {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	Scanner sc = new Scanner(System.in);
	String sql = "";
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	public Ex3MysqlBit() {
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch(ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패: " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "angel", "1234");
			System.out.println("로컬 Mysql 연결 성공");
		} catch (SQLException e) {
			System.out.println("로컬 Mysql 연결 실패" + e.getMessage());
		}
		return conn;		
	}
	
	// 메뉴
	public int getmenu() {
		System.out.println("1. 데이터추가 2. 전체출력 3. 이름검색 4. 평균검색 5. 종료");
		int input = 0;
		try {
			input = Integer.parseInt(sc.nextLine());
			
		} catch(NumberFormatException e) {
			input = 5;
		}
		return input;
		
	}
	
	// 2. 전체 출력
	private void infoAll() {
		conn = this.getConnection();
		sql = "select * from bitcamp";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Timestamp ts = rs.getTimestamp("today");
				System.out.println("=".repeat(40));
				System.out.println("번호: " + rs.getInt("num"));
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("자바점수: " + rs.getInt("java"));
				System.out.println("스프링점수: " + rs.getInt("spring"));
				System.out.println("글쓴날짜: " + new SimpleDateFormat("yyyy-MM-dd").format(ts));
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
	
	// 3. 이름
	private void searchName(String name) {
		sql = "select num, name, java + spring sum, round(java + spring / 2, 1) avg, today "
				+ "from bitcamp "
				+ "where name like '" + name + "%'";
		conn = this.getConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Timestamp ts = rs.getTimestamp("today");
				System.out.println("=".repeat(40));
				System.out.println("번호: " + rs.getInt("num"));
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("점수합계: " + rs.getInt("sum"));
				System.out.println("평균: " + rs.getInt("avg"));
				System.out.println("날짜: " + new SimpleDateFormat("yyyy-MM-dd").format(ts));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException e) {e.printStackTrace();}
			
		}
	}
	
	// 4. 평균
	private void searchAvg(int avg) {
		sql = "select * from bitcamp where ((java + spring) / 2) >=" + avg;
		conn = this.getConnection();
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Timestamp ts = rs.getTimestamp("today");
				System.out.println("=".repeat(40));
				System.out.println("번호: " + rs.getInt("num"));
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("자바점수: " + rs.getInt("java"));
				System.out.println("스프링점수: " + rs.getInt("spring"));
				System.out.println("글쓴날짜: " + new SimpleDateFormat("yyyy-MM-dd").format(ts));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException e) {e.printStackTrace();}
			
		}
	}	
	
	// 메인
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Exit: while(true) {			
			Ex3MysqlBit ex3 = new Ex3MysqlBit();
			switch (ex3.getmenu()) {
			case 1:
				ex3.insertData();
				break;
			case 2:
				ex3.infoAll();
				break;
			case 3:
				System.out.println("이름 입력");
				String name = sc.nextLine();
				ex3.searchName(name);
				break;
			case 4:
				System.out.println("숫자 입력");
				int avg = Integer.parseInt(sc.nextLine());
				ex3.searchAvg(avg);
				break;
			case 5:
				System.out.println("종료합니다");
				break Exit;
			default:
				System.out.println("잘못된 입력. 종료합니다");
				break Exit;
			}
		}
		sc.close();
	}

	private void insertData() {
		System.out.println("추가할 이름은?");
		String name = sc.nextLine();
		System.out.println("추가할 자바점수는?");
		int java = Integer.parseInt(sc.nextLine());
		System.out.println("추가할 스프링점수는?");
		int spring = Integer.parseInt(sc.nextLine());
		
		sql = "insert into bitcamp (name, java, spring, today) values ('" + name + "', " + java + ", " + spring + ", now())";
//		System.out.println(sql);
		conn = this.getConnection();
		
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("데이터가 추가되었습니다");
		} catch (SQLException e) {
			System.out.println("insert 오류: " + e.getMessage());
		} finally {
			try {
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e) {	}
		}
		
	}


}
