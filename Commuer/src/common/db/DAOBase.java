package common.db;
import javax.naming.*;
import javax.sql.*;
public class DAOBase {

	protected DataSource ds;
	protected Context ctx;
	public DAOBase() {
		try {
			ctx=new InitialContext(); //윈도우탐색기 같은놈
			ds=(DataSource)ctx.lookup("java:comp/env/oracle/myshop"); //탐색기에 데이터의 위치를 지정해준다
			System.out.println("데이터 소스 룩업 성공!");
		} catch (NamingException e) {
			
			e.printStackTrace();
		} 
	}

}
