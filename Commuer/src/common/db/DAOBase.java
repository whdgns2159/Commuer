package common.db;
import javax.naming.*;
import javax.sql.*;
public class DAOBase {

	protected DataSource ds;
	protected Context ctx;
	public DAOBase() {
		try {
			ctx=new InitialContext(); //������Ž���� ������
			ds=(DataSource)ctx.lookup("java:comp/env/oracle/myshop"); //Ž���⿡ �������� ��ġ�� �������ش�
			System.out.println("������ �ҽ� ��� ����!");
		} catch (NamingException e) {
			
			e.printStackTrace();
		} 
	}

}
