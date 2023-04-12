package rs.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSession session;
	
	String nameSpace = "rs.dao.MemberDao.";
	
	public int totalCount() {
		return session.selectOne(nameSpace + "totalCountOfMember");
	}
}
