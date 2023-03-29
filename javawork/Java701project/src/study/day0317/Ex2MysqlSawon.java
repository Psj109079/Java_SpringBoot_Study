package study.day0317;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex2MysqlSawon {
	static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String MYSQL_URL = "jdbc:mysql://localhost:3306/bit701?serverTimezone=Asia/Seoul";
	
	public Ex2MysqlSawon() {
		
		try {
			Class.forName(MYSQL_DRIVER);
			System.out.println("Mysql 드라이버 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql 드라이버 실패: " + e.getMessage());
		}
	}
	
	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(MYSQL_URL, "angel", "1234");
			System.out.println("로컬 Mysql 연결 성공");
		} catch (SQLException e) {
			System.out.println("로컬 Mysql 연결 실패" + e.getMessage());
		}
		
		return conn;
	}
	
	public void writeSawon() {
		Connection conn = this.getConnection();
		String sql = "select sawon.num, name, gender, buseo, age, hp, addr, score "
				+ "from sawon"
				+ " inner join sawoninfo on sawon.num = sawoninfo.num;";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int age = rs.getInt("age");
				String hp = rs.getString("hp");
				String addr = rs.getString("addr");
				int score = rs.getInt("score");
				
				System.out.println();
				System.out.println("=".repeat(30));
				System.out.println("**" + name + " 사원의 개인정보 **");
				System.out.println("num = " + num + ", score = " + score);
				System.out.println("부서명: " + buseo + ", 성별: " + gender);
				System.out.println("주소: " + addr + ", 핸드폰: " + hp);
				System.out.println("나이: " + age);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(stmt != null) {stmt.close();}
				if(conn != null) {conn.close();}
			} catch (SQLException e) {}
		}
	}
	
	private void countSawon() {
		// 사원이 총 몇명인지 구하지
		Connection conn = this.getConnection();
		String sql = "select count(*) cnt from sawon, sawoninfo where sawon.num = sawoninfo.num";
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next()) {
				System.out.println("총 " + rs.getInt("cnt")+ "명의 사원이 있습니다");				
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
	private void bunseokSawon() {
		Connection conn = this.getConnection();
		String sql = "select buseo, count(buseo) emp, round(avg(score), 1) avgscore, max(score) maxscore, min(score) minscore \r\n"
				+ " from sawon group by buseo";
		System.out.println("부서명 인원수 평균점수 최고점수 최저점수");
		System.out.println("=".repeat(40));
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("buseo") + " " + rs.getInt("emp") + " " + rs.getDouble("avgscore") + " " + rs.getInt("maxscore") + " " + rs.getInt("minscore"));
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

	public static void main(String[] args) {
		Ex2MysqlSawon ex2 = new Ex2MysqlSawon();
		ex2.countSawon();
		ex2.writeSawon();
		ex2.bunseokSawon();
	}

	
	
}
