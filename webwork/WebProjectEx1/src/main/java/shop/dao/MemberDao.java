package shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnect;
import shop.dto.MemberDto;

public class MemberDao {
	DbConnect db = new DbConnect();
	String sql;
	
	
	// 중복검사
	public boolean duplicate(String id) {
		boolean a = false;
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		sql = "select id from member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(id.equals(rs.getString("id"))) {
					a = true;
					return a;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn, rs);
		}
		return a;
	}
	
	// 회원가입 
	public void join(MemberDto dto) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "insert into member(id, pw, name, address) values(?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 모든 데이터 출력
	public List<MemberDto> getAllData(){
		List<MemberDto> list = new ArrayList<>();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		sql = "select * from member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn, rs);
		}
		return list;		
	}
	
	// id 값으로 정보 받아오기
	public MemberDto detailMember(String id) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		sql = "select * from member where id = ?";
		MemberDto dto = new MemberDto();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
			
	// 회원 정보수정
	public void updateMember(MemberDto dto, String renameId) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "update member set id = ?, pw = ?, name = ?, address = ? where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, renameId);
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getAddress());
			pstmt.setString(5, dto.getId());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	// 탈퇴
	public void secessionMember(String id) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		
		sql = "delete from member where id = ?";
		
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
}
