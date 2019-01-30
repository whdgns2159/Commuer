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

	/**�Խ��� ����Ʈ �Լ�*/
	public String NSChoice(String tn){
		switch(tn) {
			case "0":
				NS="board.model.NoticeMapper";
				break;
			/*case "1":
				NS="board.model.Mapper1";
				break;*/
			case "2":
				NS="board.model.FreeBoardMapper"; //�����Խ���
				break;
			case "3":
				NS="board.model.HumorBoardMapper"; //���ӰԽ���
				break;
			case "4":
				NS="board.model.MusicBoardMapper"; //���ǰԽ���
				break;
			case "5":
				NS="board.model.StarBoardMapper"; //���ǰԽ���
				break;
		}
		return NS;
	}
	//---------------------------------------------------------------------
	/**�ش� �Խ����� DB ������*/
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
	
	/**�Խù� �ۼ��ϱ�*/
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
	/**�Խù� �����ϱ�*/
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
	
	/**������ �Խñ� �ҷ�����*/
	public BoardVO getArticle(String tn, int num) { //�Խ��ǹ�ȣ�� �ش�Խ����� �Խñ۹�ȣ�� �޾ƿ´�.
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession();
			BoardVO vo=ses.selectOne(NS+".getArticle", num);
		
			return vo;
		}finally {
			if(ses!=null) ses.close();
		}
	}
	/**������ ����*/
	public void increaseLikes(String tn, int num) {
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession();
			ses.update(NS+".increaseLikes", num);
		
		}finally {
			if(ses!=null) ses.close();
		}
	}
	/**��� �ۼ��ϱ�*/
	public int subReply(String tn, ReplyVO vo) {//�Խ��ǹ�ȣ, �Խñ۹�ȣ, ���, �ۼ��ھ��̵� �޾ƿ���
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession(true);
			int n=ses.insert(NS+".subReply", vo);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**������ �Խñ��� ��� �ҷ�����*/
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
	
	/**��ۼ� ��������*/
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
	/**��ȸ�� ����*/
	public void	increaseHits(String tn, int num) {
		try {
			NS=NSChoice(tn);
			
			ses=fac.openSession(true);
			ses.update(NS+".increaseHits", num);
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**����¡ó���� ���� �� �Խù��� ��������*/
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
	
	/**�Խ����� �ϸ�ũ�ϴ� �޼ҵ�*/
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
	
	/**�Խ��Ǻ� �ϸ�ũ ���� ��������*/
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
	/**�Խ��� �ϸ�ũ�� ����ϴ� �޼ҵ�*/
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
	/**�Խñ� ����*/
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
	
	/**�Խ��� �˻��� ó��*/
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
	/**�˻��� Ű���尡 �� �Խù��� �� �Խù� �� ��������*/
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
