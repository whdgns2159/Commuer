package board.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	private  String NS="board.model.Mapper1";
	
	private SqlSession ses;
	private SqlSessionFactory fac;
	
	public	BoardDAO() {
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

	/**해당 게시판의 DB 얻어오기*/
	
	public List<BoardVO> getSelectedBoard(String tn) {
		try {
		switch(tn) {
		/*case "1":
			NS="board.model.Mapper1";
			break;*/
		case "2":
			NS="board.model.FreeBoardMapper";
			break;
		case "3":
			NS="board.model.Mapper3";
			break;
		}
		ses=fac.openSession();
		List<BoardVO> arr=ses.selectList(NS+".boardContent");
		return arr;
		}finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**선택한 게시글 불러오기*/
	
	
}
