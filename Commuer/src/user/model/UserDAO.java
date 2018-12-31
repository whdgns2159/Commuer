package user.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserDAO {

	private final String NS="user.model.UserMapper";
	private SqlSession ses;
	private SqlSessionFactory fac;
	
	public UserDAO() {
		String resource="config/config.xml";
		InputStream is=null;
		
		try {
			is=Resources.getResourceAsStream(resource);
			fac=new SqlSessionFactoryBuilder().build(is);
			//System.out.println("fac= "+fac);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/**아이디 중복체크 여부를 반환하는 메소드*/
	/*public boolean isDuplicatedId(String userid){
		try {
			ses=fac.openSession();
			ses.selectOne(userid);
		} finally {
			if(ses!=null) ses.close();
		}
	}
	*/
	public int createUser(UserVO uvo) {
		try {
			ses=fac.openSession(true);
			int n=ses.insert(NS+".createUser", uvo);
			return n;
		}finally {
			if(ses!=null) ses.close();
		}
	}
	
	public UserVO userLogin(String id){
		try {
			ses=fac.openSession();
			UserVO userInfo=ses.selectOne(NS+".userLogin", id);
			
			return userInfo;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
}
