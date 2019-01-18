package ex02;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx
		=new ClassPathXmlApplicationContext("ex02/user_jdbc.xml");
		
		UserDAO dao=ctx.getBean("userDaoJdbc",UserDAO.class);
		int n0=dao.createUser(new UserVO(0,"임길동","Lim","111",new Date()));
		System.out.println((n0>0)?"회원정보 등록 성공!!":"회원정보 등록 실패" );
		
		List<UserVO> uList=dao.listUser();
		for(UserVO u:uList){
			System.out.println(u);
			System.out.println("--------------");
		}
		int n1=dao.deleteUser(5);
		System.out.println((n1>0)?"삭제성공":"삭제 실패");
		
		int n2=dao.updateUser(new UserVO(1,"홍길남","Hong","222",null));
		System.out.println((n2>0)?"수정 성공":"수정 실패");
		
		UserVO user=dao.getUser(1);
		System.out.println(user);
		
		int count=dao.getUserCount();
		System.out.println("총 회원수: "+ count);
		
	}

}
