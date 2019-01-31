package board.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;
import user.model.UserBookmarkVO;
import user.model.UserVO;

public class BoardAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tnStr=req.getParameter("tn");
		int tn=Integer.parseInt(tnStr);
		
		BoardDAO dao=new BoardDAO();
		
	
		/**����¡ ó���ϱ�*/
		
		String cpStr=req.getParameter("cpage");
		int pagingBlock=10;
		int prevBlock=0;
		int nextBlock=0;
		if(cpStr==null||cpStr.trim().isEmpty()) {
			cpStr="1";
		}

		int cpage=Integer.parseInt(cpStr);
		if(cpage<=0) {
			cpage=1;
		}
		
		int totalCount=dao.getTotalCount(tnStr);
		int pageSize=10;
		int pageCount=0;
		
		pageCount=(totalCount-1)/pageSize+1;
		
		if(cpage>pageCount) {
			cpage=pageCount;//������ ������ �����ֵ���
		}
		
		prevBlock=(cpage-1)/pagingBlock*pagingBlock;
		nextBlock=prevBlock+(pagingBlock+1);

		int end=cpage*pageSize;
		int start=end -(pageSize-1);
		
		StringBuilder buf=new StringBuilder().append("<ul class='pagination'>");
		
		if(prevBlock>0){
			buf.append("<li><a class='page-link' href='board.do?tn="+tnStr+"&cpage="+prevBlock+"'>");
			buf.append("Prev");
			buf.append("</a></li>");
		}
		for(int i=prevBlock+1;i<=nextBlock-1&& i<=pageCount;i++){
			String css="";
			if(i==cpage) {
				css="class='active'";
			}
			buf.append("<li "+css+"><a class='page-link' href='board.do?tn="+tnStr+"&cpage="+i+"'>"+i+"</a>");
			buf.append("</li>");
		}
		if(nextBlock<pageCount){
			buf.append("<li><a class='page-link' href='board.do?tn="+tnStr+"&cpage="+nextBlock+"'>");
			buf.append("Next");
			buf.append("</a></li>");
		}
		buf.append("</ul>");
		String pagination=buf.toString();
		
		//------------------------------------------------------------------
		
		/**�Խù� ��������*/
		List<BoardVO> arr=dao.getSelectedBoard(tnStr, start, end);
		
		/**����ð��� �Խù� �ۼ��ð� ���ؼ� 
		 * �����ۼ��� ���̶�� �ð�����ǥ���ϱ� (�̿ϼ�)*/
		
		
		/**�ϸ�ũ ���� ��������*/
		HttpSession ses=req.getSession();
		UserVO userInfo=(UserVO)ses.getAttribute("loginUser");
		String id="";
		if(userInfo!=null) {
			id=userInfo.getId();
		}
		List<UserBookmarkVO> bookmark=dao.getBookmark(id, tnStr);
		
		if(bookmark!=null ) {
			Iterator<UserBookmarkVO> it=bookmark.iterator();
			while(it.hasNext()) {
				UserBookmarkVO vo=it.next();
				if(vo.getTn().equals(tnStr)) {
					req.setAttribute("BM", vo.getTn());
				}
				
			}
			
		}
		//-----------------------------------------------------------------
		
		/**�Խ����̸� ǥ�����ֱ�*/
		String tName="";
		switch(tn) {
		case 1:tName="�α�";
		break;
		case 2:tName="����";
		break;
		case 3:tName="����";
		break;
		case 4:tName="����";
		break;
		case 5:tName="����";
		break;
		}
		//-----------------------------------------------------------------
		
		
		req.setAttribute("BT", arr);
		req.setAttribute("tn", tn);
		req.setAttribute("tName", tName);
		
		
		req.setAttribute("pagination", pagination);
		String viewPage="board/board.jsp";
		
		this.setViewPage(viewPage);
		this.setRedirect(false);
		
	}

}
