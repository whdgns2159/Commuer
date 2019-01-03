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
			int inttn=Integer.parseInt(tn);
			if(inttn<1) {
				tn="1";
			}
		switch(tn) {
		/*case "1":
			NS="board.model.Mapper1";
			break;*/
		case "2":
			NS="board.model.FreeBoardMapper"; //자유게시판
			break;
		case "3":
			NS="board.model.HumorBoardMapper"; //유머게시판
			break;
		}
		ses=fac.openSession();
		List<BoardVO> arr=ses.selectList(NS+".boardContent");
		return arr;
		}finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**게시물 작성하기*/
	public int insertBoard(String tn, BoardVO vo){
		try {
			int intTn=Integer.parseInt(tn);
			if(intTn<1) {
				tn="1";
			}
		switch(tn) {
		/*case "1":
			NS="board.model.Mapper1";
			break;*/
		case "2":
			NS="board.model.FreeBoardMapper"; //자유게시판
			break;
		case "3":
			NS="board.model.HumorBoardMapper"; //유머게시판
			break;
		}
			ses=fac.openSession(true);
			int n=ses.insert(NS+".articleWrite",vo);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**선택한 게시글 불러오기*/
	
	
}
