package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import db.DbConnect;
import study.dto.ShopDto;


public class ShopDao {
	DbConnect db = new DbConnect();
	
	// insert
	public void insertShop(ShopDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into shop values(null, ?, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			// 바인딩
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getColor());
			pstmt.setString(3, dto.getPhoto());
			pstmt.setInt(4, dto.getSu());
			pstmt.setInt(5, dto.getDan());
			pstmt.setString(6, dto.getIpgoday());
			
			// 실행
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(null, conn);
		}
	}
	
	// 출력(검색)
	public List<ShopDto> getSangpumList(String search) {
		List<ShopDto> list = new ArrayList<>();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from shop where sangpum like ? order by num desc";
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 바인딩
			pstmt.setString(1, "%" + search + "%");
			// 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ShopDto dto = new ShopDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setColor(rs.getString("color"));
				dto.setPhoto(rs.getString("photo"));
				dto.setSu(rs.getInt("su"));
				dto.setDan(rs.getInt("dan"));
				dto.setIpgoday(rs.getString("ipgoday"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn, rs);
		}
		return list;
	}
	
	// 상품 한개 가져오기
	public ShopDto getSangpum(int num) {
		ShopDto dto = new ShopDto();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from shop where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto.setNum(rs.getInt("num"));
				dto.setSangpum(rs.getString("sangpum"));
				dto.setColor(rs.getString("color"));
				dto.setPhoto(rs.getString("photo"));
				dto.setSu(rs.getInt("su"));
				dto.setDan(rs.getInt("dan"));
				dto.setIpgoday(rs.getString("ipgoday"));
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn, rs);
		}
		return dto;
	}
	
	// 수정
	public void updateShop(ShopDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update shop set sangpum = ?, color = ?, photo = ?, su = ?, dan = ?, ipgoday = ? where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getSangpum());
			pstmt.setString(2, dto.getColor());
			pstmt.setString(3, dto.getPhoto());
			pstmt.setInt(4, dto.getSu());
			pstmt.setInt(5, dto.getDan());
			pstmt.setString(6, dto.getIpgoday());
			pstmt.setInt(7, dto.getNum());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	// 삭제
	public void deleteShop(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from shop where num = ?";
		
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
