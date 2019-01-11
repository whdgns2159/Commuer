package user.model;

import java.io.IOException;
import java.io.InputStream;

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
	

	/**���̵� �ߺ�üũ ���θ� ��ȯ�ϴ� �޼ҵ�*/
	public boolean isDuplicatedId(String id){
		try {
			ses=fac.openSession();
			boolean b=ses.selectOne(NS+".idCheck", id);
			
			return b;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**ȸ�������� ���� ��������*/
	public int createUser(UserVO uvo) {
		try {
			ses=fac.openSession(true);
			int n=ses.insert(NS+".createUser", uvo);
			return n;
		}finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**�α��ν� �������� Ȯ��*/
	public UserVO userLogin(String id){
		try {
			ses=fac.openSession();
			UserVO userInfo=ses.selectOne(NS+".userLogin", id);
			
			return userInfo;
		} finally {
			if(ses!=null) ses.close();
		}
	}

	/**���� ȸ������ ����*/
	public int userAdjust(UserVO vo) {
		try {
			ses=fac.openSession(true);
			int n=ses.update(NS+".userAdjust", vo);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}

	}



	
}
