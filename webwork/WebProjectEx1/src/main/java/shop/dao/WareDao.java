package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnect;
import shop.dto.WareDto;

public class WareDao {
	DbConnect db = new DbConnect();
	String sql = "";
	
	// 상품 추가
	public void insertWare(WareDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "insert into ware values(null, ?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getType());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getSize());
			pstmt.setString(4, dto.getImage());
			pstmt.setInt(5, dto.getPrice());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 검색
	public List<WareDto> searchWare(String name) {
		List<WareDto> list = new ArrayList<>();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		sql = "select * from ware where instr(name, ?) > 0";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				WareDto dto = new WareDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setType(rs.getString("type"));
				dto.setName(rs.getString("name"));
				dto.setSize(rs.getString("size"));
				dto.setImage(rs.getString("image"));
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
	
	// 출력
	public List<WareDto> allSearchWare() {
		List<WareDto> list = new ArrayList<>();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		sql = "select * from ware order by num";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				WareDto dto = new WareDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setType(rs.getString("type"));
				dto.setName(rs.getString("name"));
				dto.setSize(rs.getString("size"));
				dto.setImage(rs.getString("image"));
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
	
	// 상세출력
	public WareDto wareDetail(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		WareDto dto = null;
		sql = "select * from ware where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new WareDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setType(rs.getString("type"));
				dto.setName(rs.getString("name"));
				dto.setSize(rs.getString("size"));
				dto.setImage(rs.getString("image"));
				dto.setPrice(rs.getInt("price"));
				
				pstmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn, rs);
		}	
		return dto;
	}
	
	// 수정
	public void updateWare(WareDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "update ware set type = ?, name = ?, size = ?, image = ?, price = ? where num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getType());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getSize());
			pstmt.setString(4, dto.getImage());
			pstmt.setInt(5, dto.getPrice());
			pstmt.setInt(6, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	// 삭제
	public void deleteWare(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "delete from ware where num = ?";
		
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
