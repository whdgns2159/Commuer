package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class boardDAO {
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public void selectBoard(int index) {
		
	}
	
	
	public void close() {
		try {
		if(rs!=null) rs.close();
		if(ps!=null) ps.close();
		if(con!=null) con.close();
		}catch(SQLException e) {
			System.out.println("error: "+e);
		}
	}

}
