package board.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	private  String NS="board.model.FreeBoardMapper";
	
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

	/**게시판 셀렉트 함수*/
	public String bChoice(String tn){
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
			case "4":
				NS="board.model.MusicBoardMapper"; //음악게시판
				break;
			case "5":
				NS="board.model.StarBoardMapper"; //음악게시판
				break;
		}
		return NS;
	}
	//---------------------------------------------------------------------
	/**해당 게시판의 DB 얻어오기*/
	public List<BoardVO> getSelectedBoard(String tn) {
		try {
			int inttn=Integer.parseInt(tn);
			if(inttn<1) {
				tn="1";
			}if(inttn>5) {
				tn="1";
			}
				
			NS=bChoice(tn);
			
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
			NS=bChoice(tn);
			
			ses=fac.openSession(true);
			int n=ses.insert(NS+".articleWrite",vo);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**선택한 게시글 불러오기*/
	public BoardVO getArticle(String tn, String num) { //게시판번호와 해당게시판의 게시글번호를 받아온다.
		try {
			NS=bChoice(tn);
			
			ses=fac.openSession();
			BoardVO vo=ses.selectOne(NS+".getArticle", num);
			return vo;
		}finally {
			if(ses!=null) ses.close();
		}
	}
}
