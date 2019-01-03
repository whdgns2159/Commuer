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

	
	/**�ش� �Խ����� DB ������*/
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
			NS="board.model.FreeBoardMapper"; //�����Խ���
			break;
		case "3":
			NS="board.model.HumorBoardMapper"; //���ӰԽ���
			break;
		}
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
			int intTn=Integer.parseInt(tn);
			if(intTn<1) {
				tn="1";
			}
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
		}
			ses=fac.openSession(true);
			int n=ses.insert(NS+".articleWrite",vo);
			
			return n;
		} finally {
			if(ses!=null) ses.close();
		}
	}
	
	/**������ �Խñ� �ҷ�����*/
	
	
}
