package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnect;
import study.dto.SawonDto;

public class SawonDao {
	DbConnect db = new DbConnect();
	
	public List<SawonDto> selectAll(int num) {
		List<SawonDto> list = new ArrayList<>();
		
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from sawon order by num";
		String maleSql = "select * from sawon where gender = '남자'";
		String femaleSql = "select * from sawon where gender = '여자'";
		
		try {
			if(num == 1) {
				pstmt = conn.prepareStatement(sql);				
			} else if(num == 2) {
				pstmt = conn.prepareStatement(maleSql);				
			} else {
				pstmt = conn.prepareStatement(femaleSql);								
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SawonDto dto = new SawonDto(rs.getInt("num"), rs.getString("name"), rs.getInt("score"), rs.getString("gender"), rs.getString("buseo"));
				
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn, rs);
		}
		return list;
	}
}
