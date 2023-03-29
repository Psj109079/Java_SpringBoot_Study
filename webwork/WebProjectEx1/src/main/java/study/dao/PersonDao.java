package study.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DbConnect;
import study.dto.PersonDto;

public class PersonDao {
	DbConnect db = new DbConnect();

	// insert
	public void insertPerson(PersonDto dto) {
		Connection conn = db.getMysqlConnection();

		PreparedStatement pstmt = null;
		String sql = "insert into person values (null, ?, ?, ?, ?, ?)";

		try {
			pstmt = conn.prepareStatement(sql);

			// 바인딩
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getBirthyear());
			pstmt.setString(3, dto.getAdress());
			pstmt.setString(4, dto.getJob());
			pstmt.setString(5, dto.getPhoto());

			// 실행
			pstmt.execute();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// delete
	public void deletePerson(int num) {
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		String sql = "delete from person where num = " + num;		
		
		try {
			pstmt = conn.prepareStatement(sql);
			// 실행	
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}

	// get date
	public PersonDto getData(int num) {
		return null;
	}

	// update
	public void updatePerson(PersonDto dto) {

	}

	// db에서 데이터를 list에 담아서 리턴하는 메서드
	public List<PersonDto> getAllPerson() {
		List<PersonDto> list = new ArrayList<>();
		Connection conn = db.getMysqlConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from person order by num";

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				PersonDto dto = new PersonDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setBirthyear(rs.getInt("birthyear"));
				dto.setAdress(rs.getString("address"));
				dto.setJob(rs.getString("job"));
				dto.setPhoto(rs.getString("photo"));

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
