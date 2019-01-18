package ex04;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppTest {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("ex04/appContext.xml");
		
		UserDAO dao=ctx.getBean("userDAOMyBatis", UserDAO.class);
		
		List<UserVO> arr=dao.listUser();
		
		if(arr!=null) {
			for(UserVO u:arr) {
				System.out.println(u.toString());
			}
		}

	}

}
