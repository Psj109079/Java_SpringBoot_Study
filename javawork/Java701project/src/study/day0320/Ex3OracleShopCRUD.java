package study.day0320;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;


public class Ex3OracleShopCRUD {
	static final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	static final String ORACLE_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	
	Scanner sc = new Scanner(System.in);
	
	Ex3OracleShopCRUD() {
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
	
	public int getMenu() {
		int menu = 0;
		System.out.println(" ** Shop 메뉴 ** ");
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 조회");
		System.out.println("3. 상품 수정");
		System.out.println("4. 상품 삭제");
		System.out.println("5. 종 료");
		 menu = Integer.parseInt(sc.nextLine());
		 return menu;
	}
	
	// 추가
	public void addSangpum() {
		
		System.out.println("상품명은?");
		String sangpum = sc.nextLine();
		System.out.println("색상은?");
		String color = sc.nextLine();
		System.out.println("수량은?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("단가는?");
		int dan = Integer.parseInt(sc.nextLine());
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into shop (num, sangpum, color, su, dan, today)values (seq_test.nextval, ?, ?, ?, ?, sysdate)";
		
		try {
			pstmt = conn.prepareStatement(sql); // statement 생성 시 sql문 검사
			// ? 갯수만큼 데이터 바인딩 (?는 1, 2, 3, 4 순서)
			pstmt.setString(1, sangpum);
			pstmt.setString(2, color);
			pstmt.setInt(3, su);
			pstmt.setInt(4, dan);
			// 실행
			pstmt.execute();
			System.out.println(sangpum + " 상품이 추가되었습니다");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException e) {}
		}	
	}
	
	// 조회
	public void selectShop() {
		System.out.println("검색할 상품을 입력하세요");
		String sang = sc.nextLine();
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from shop where sangpum like ? order by num asc";
		
		try {
			pstmt = conn.prepareStatement(sql);		
			
			// 바인딩
			pstmt.setString(1, "%" + sang.trim() + "%");
			rs = pstmt.executeQuery();
			
			System.out.println("검색 결과에 대한 상품");
			System.out.println();
			System.out.println("번호\t상품명\t색상\t수량\t단가\t날짜");
			
			while(rs.next()) {
				System.out.println(rs.getInt("num") + "\t" + rs.getString("sangpum") + "\t" + rs.getString("color") + "\t" + rs.getInt("su") + "\t" + rs.getInt("dan") + rs.getString("today").substring(0, 10));
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException e) {}
		}
	}
	
	// 수정
	public void updateSangpum() {
		System.out.println("수정할 num 값은?");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 수량은?");
		int su = Integer.parseInt(sc.nextLine());
		System.out.println("수정할 색상은?");
		String color = sc.nextLine();
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update shop set su = ?, color = ? where num = ?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);		
			
			// 바인딩
			pstmt.setInt(1, su);
			pstmt.setString(2, color);
			pstmt.setInt(3, num);
			
			// 실행 
			int n = pstmt.executeUpdate();
			
			if(n == 0) {
				System.out.println("해당 num 값이 존재하지 않습니다");
			} else {
				System.out.println("해당 상품이 수정되었습니다");
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException e) {}
		}
	}
	
	// 삭제
	public void deleteSangpum() {
		System.out.println("삭제할 num 값은?");
		int delNum = Integer.parseInt(sc.nextLine());
		
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from shop where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);		
			
			pstmt.setInt(1, delNum);
			
			int n = pstmt.executeUpdate();
			
			if(n == 0) {
				System.out.println("해당 번호의 상품이 없습니다");
			} else {
				System.out.println("해당 상품이 삭제되었습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch(SQLException e) {}
		}
	}
	
	public static void main(String[] args) {
		Ex3OracleShopCRUD ex = new Ex3OracleShopCRUD();
		
		while(true) {
			switch (ex.getMenu()) {
			case 1:
				ex.addSangpum();
				break;
			case 2:
				ex.selectShop();
				break;
			case 3:
				ex.updateSangpum();
				break;
			case 4:
				ex.deleteSangpum();
				break;
			default:
				System.out.println("** 프로그램을 종료합니다 **");
				System.exit(0);
			}
		}
	}

}
