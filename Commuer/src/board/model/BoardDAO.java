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

	/**�Խ��� ����Ʈ �Լ�*/
	public String bChoice(String tn){
		switch(tn) {
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
	
	/**�Խù� �ۼ��ϱ�*/
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
	
	/**������ �Խñ� �ҷ�����*/
	public BoardVO getArticle(String tn, String num) { //�Խ��ǹ�ȣ�� �ش�Խ����� �Խñ۹�ȣ�� �޾ƿ´�.
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
