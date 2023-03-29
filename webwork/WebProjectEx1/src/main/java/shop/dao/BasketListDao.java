package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnect;
import shop.dto.BasketListDto;
import shop.dto.WareDto;

public class BasketListDao {
	DbConnect db = new DbConnect();
	String sql = "";
	
	// 저장
	public void saveBasketList(String id, String size, WareDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "insert into basketlist values(null, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, dto.getNum());
			pstmt.setString(3, dto.getImage());
			pstmt.setString(4, dto.getName());
			pstmt.setString(5, size);
			pstmt.setInt(6, dto.getPrice());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);

		}
	}
	// 출력
	public List<BasketListDto> allBasketData(String id) {
		List<BasketListDto> list = new ArrayList<>();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		sql = "select b.prinum, b.id, b.num, b.image, b.name, b.size, b.price "
				+ "from basketlist as b inner join member as m on b.id = m.id where b.id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BasketListDto dto = new BasketListDto();
				
				dto.setPrinum(rs.getInt("prinum"));
				dto.setId(rs.getString("id"));
				dto.setNum(rs.getInt("num"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setSize(rs.getString("size"));
				dto.setPrice(rs.getInt("price"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn, rs);
		}	
		return list;
	}
	
	// 삭제
	public void deleteBasket(String id, int prinum) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "delete from basketlist where id = ? and prinum = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, prinum);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// id 변경
	public void updateIdBasket(String updateId, String id) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "update basketlist set id = ?  where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updateId);
			pstmt.setString(2, id);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// id 삭제시 id가 담아놓은 장바구니도 삭제
	public void deleteBasketlist(String id) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "delete from basketlist where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 상품 수정 & 삭제 시 장바구니 삭제
	public void deleteBasketlist(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "delete from basketlist where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
}