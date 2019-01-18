package ex03;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppTest {

	public static void main(String[] args) {
		ApplicationContext ctx
		=new ClassPathXmlApplicationContext("ex03/appContext.xml");
		
		//UserDAOMyBatis빈 을 찾아서 getUserCount()호출하여 반환값 출력하기
		UserDAO dao=ctx.getBean("userDAOMyBatis",UserDAO.class);
		int cnt=dao.getUserCount();
		System.out.println("현재 총 회원수: "+cnt+"명");
		
		Scanner sc=new Scanner(System.in);
		System.out.println("이름=>");
		String name=sc.next();
		System.out.println("아이디=>");
		String userid=sc.next();
		System.out.println("비밀번호=>");
		String pwd=sc.next();
		
		System.out.println(name+"/"+userid+"/"+pwd);
		
		UserVO user=new UserVO(0,name,userid,pwd,null);
		int n=dao.createUser(user);
		System.out.println("방금 등록한 회원의 회원번호 idx=>"+user.getIdx());
		
		System.out.println((n>0)?"등록 성공":"등록 실패");
		
		System.out.println("등록후 회원수: "+dao.getUserCount());
		
		List<UserVO> arr=dao.listUser();
		if(arr!=null) {
			for(UserVO u:arr) {
				System.out.println(u.toString());
			}//for-----
		}//if-----------------------
		
		System.out.println("3번 회원 정보 삭제 시작");
		int n2=dao.deleteUser(3);
		System.out.println((n2>0)?"삭제 성공":"삭제 실패");
		
		UserVO user2=new UserVO(6,"김수정","sujung","123",null);
		int n3=dao.updateUser(user2);
		System.out.println((n3>0)?"수정 성공":"수정 실패");
		
		System.out.println("수정된 회원 정보-------");
		UserVO user3=dao.getUser(6);
		System.out.println(user3.toString());

	}

}



