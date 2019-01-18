package ex03;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
/*[1] Template을 이용하는 방법==> ex03패키지
 *[2] DaoSupport를 이용하는 방법 ==> ex04패키지
 * 
 * */
public class UserDAOMyBatis implements UserDAO{

	private SqlSessionTemplate session;
	private final String NS="ex03.UserMapper";
	
	public SqlSessionTemplate getSession() {
		return session;
	}

	public void setSession(SqlSessionTemplate session) {
		this.session = session;
	}

	//SqlSession
	@Override
	public int createUser(UserVO user) {		
		return session.insert(NS+".createUser",user);
	}

	@Override
	public List<UserVO> listUser() {
		return session.selectList(NS+".listUser");
	}

	@Override
	public int deleteUser(int idx) {
		return session.delete(NS+".deleteUser",idx);
	}

	@Override
	public int updateUser(UserVO user) {
		return session.update(NS+".updateUser", user); 
	}

	@Override
	public UserVO getUser(int idx) {
		return session.selectOne(NS+".getUser",idx);
	}
 
	@Override
	public int getUserCount() {
		return session.selectOne(NS+".getUserCount"); 
	}

}





