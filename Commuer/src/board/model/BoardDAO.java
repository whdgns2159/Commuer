package board.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import user.model.UserBookmarkVO;

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
	public String NSChoice(String tn){
		switch(tn) {
			case "0":
				NS="board.model.NoticeMapper";
				break;
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
	public List<BoardVO> getSelectedBoard(String tn, int start, int end) {
		try {
			int inttn=Integer.parseInt(tn);
			if(inttn<1) {
				tn="1";
			}if(inttn>5) {
				tn="1";
			}
				
			NS=NSChoice(tn);
			
			ses=fac.openSession();
			
			Map<String, String> num=new HashMap<>();
			
			String s=Integer.toString(start);
			String e=Integer.toString(end);
			
			num.put("start", s);
			num.put("end", e);
			
			List<BoardVO> arr=ses.selectList(NS+".boardContent", num);
		return arr;
		}finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**게시물 작성하기*/
	public int insertBoard(String tn, BoardVO vo){
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession(true);
			int n=ses.insert(NS+".articleWrite",vo);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	/**게시물 수정하기*/
	public int editArticle(String tn, Map<String, String> map){
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession(true);
			int n=ses.update(NS+".editArticle", map);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**선택한 게시글 불러오기*/
	public BoardVO getArticle(String tn, int num) { //게시판번호와 해당게시판의 게시글번호를 받아온다.
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession();
			BoardVO vo=ses.selectOne(NS+".getArticle", num);
		
			return vo;
		}finally {
			if(ses!=null) ses.close();
		}
	}
	/**공감수 증가*/
	public void increaseLikes(String tn, int num) {
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession();
			ses.update(NS+".increaseLikes", num);
		
		}finally {
			if(ses!=null) ses.close();
		}
	}
	/**댓글 작성하기*/
	public int subReply(String tn, ReplyVO vo) {//게시판번호, 게시글번호, 댓글, 작성자아이디 받아오기
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession(true);
			int n=ses.insert(NS+".subReply", vo);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**선택한 게시글의 댓글 불러오기*/
	public List<ReplyVO> getReply(String tn, int num) {
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession();
			List<ReplyVO> arr=ses.selectList(NS+".getReply", num);
			
			return arr;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**댓글수 가져오기*/
	public int totalReply(String tn, int num) {
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession();
			int n=ses.selectOne(NS+".totalReply", num);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	/**조회수 증가*/
	public void	increaseHits(String tn, int num) {
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession(true);
			ses.update(NS+".increaseHits", num);
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**페이징처리를 위한 총 게시물수 가져오기*/
	public int getTotalCount(String tn) {
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession();
			int n=ses.selectOne(NS+".articleCount");
			
			return n;
			
		} finally {
			if(ses!=null) ses.close();
		}
		
	}
	
	/**게시판을 북마크하는 메소드*/
	public int setBookmark(String tn, String id) {
		try {
			
			NS="board.model.BookmarkMapper";
			ses=fac.openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("tn", tn);
			map.put("id", id);
			
			int n=ses.insert(NS+".setBookmark", map);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
		
	}
	
	/**게시판별 북마크 여부 가져오기*/
	public List<UserBookmarkVO> getBookmark(String id, String tn) {
		try {
			NS="board.model.BookmarkMapper";
			
			ses=fac.openSession();
			Map<String, String> map=new HashMap<>();
			map.put("tn", tn);
			map.put("id", id);
			
			List<UserBookmarkVO> arr=ses.selectList(NS+".getBookmark", map);
			
			return arr;
			
		} finally {
			if(ses!=null) ses.close();
		}
		
	}
	/**게시판 북마크를 취소하는 메소드*/
	public int delBookmark(String id, String tn) {
		try {
			NS="board.model.BookmarkMapper";
			
			ses=fac.openSession(true);
			Map<String, String> map=new HashMap<>();
			map.put("id", id);
			map.put("tn", tn);
			
			int n=ses.delete(NS+".delBookmark", map);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
		
	}
	/**게시글 삭제*/
	public int delArticle(String tn, String num) {
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession(true);
			int n=ses.delete(NS+".delArticle",num);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**게시판 검색어 처리*/
	public List<BoardVO> keywordSearch(String tn, String keyword, int start, int end) {
		try {
			NS=NSChoice(tn);
			ses=fac.openSession();
			
			Map<String, String> map=new HashMap<>();
			String s=Integer.toString(start);
			String e=Integer.toString(end);
			
			map.put("start", s);
			map.put("end", e);
			map.put("keyword", keyword);
			
			List<BoardVO> searchResult=ses.selectList(NS+".keywordSearch", map);
			
			return searchResult;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	/**검색한 키워드가 들어간 게시물의 총 게시물 수 가져오기*/
	public int getKeywordCount(String tn, String keyword) {
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession();
			int n=ses.selectOne(NS+".getKeywordCount", keyword);
			
			return n;
			
		} finally {
			if(ses!=null) ses.close();
		}
		
	}
	
	
}
