package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnect;
import shop.dto.BuyListDto;
import shop.dto.WareDto;


public class BuyListDao {
	DbConnect db = new DbConnect();
	String sql = "";
	
	// 구매목록 저장
	public void saveBuyList(String id, String size, WareDto dto) {
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "insert into buylist values(?, ?, ?, ?, ?, ?, now())";
		
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
	public List<BuyListDto> allBuyData(String id) {
		List<BuyListDto> list = new ArrayList<>();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		sql = "select b.id, b.num, b.image, b.name, b.size, b.price, date "
				+ "from buylist as b inner join member as m on b.id = m.id where b.id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BuyListDto dto = new BuyListDto();
				
				dto.setId(rs.getString("id"));
				dto.setNum(rs.getInt("num"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setSize(rs.getString("size"));
				dto.setPrice(rs.getInt("price"));
				dto.setBuyTime(rs.getString("date"));
				
				list.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn, rs);
		}
		return list;	
	}
	
	// id 변경
	public void updateIdBuy(String updateId, String id) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "update buylist set id = ?  where id = ?";
		
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
	
	// id 삭제시 id의 구매내역도 삭제
	public void deleteBuylist(String id) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "delete from buylist where id = ?";
		
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
	
	// 상품 수정 & 삭제 시 구매내역 삭제
	public void deleteBuylist(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "delete from buylist where num = ?";
		
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
