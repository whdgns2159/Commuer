package ex04;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
/*[1] Template을 이용하는 방법==> ex03패키지
 *[2] DaoSupport를 이용하는 방법 ==> ex04패키지
 * => SqlSessionDaoSupport클래스를 상속받는다.
 * */
public class UserDAOMyBatis extends SqlSessionDaoSupport implements UserDAO{

	
	private final String NS="ex04.UserMapper";
	
	//SqlSession
	@Override
	public int createUser(UserVO user) {		
		return this.getSqlSession().insert(NS+".createUser",user);
	}

	@Override
	public List<UserVO> listUser() {
		return this.getSqlSession().selectList(NS+".listUser");
	}

	@Override
	public int deleteUser(int idx) {
		return this.getSqlSession().delete(NS+".deleteUser",idx);
	}

	@Override
	public int updateUser(UserVO user) {
		return this.getSqlSession().update(NS+".updateUser", user); 
	}

	@Override
	public UserVO getUser(int idx) {
		return this.getSqlSession().selectOne(NS+".getUser",idx);
	}
 
	@Override
	public int getUserCount() {
		return this.getSqlSession().selectOne(NS+".getUserCount"); 
	}

}





