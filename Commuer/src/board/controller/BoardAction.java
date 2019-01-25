package board.controller;

import java.text.SimpleDateFormat;
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
		
	
		/**페이징 처리하기*/
		
		String cpStr=req.getParameter("cpage");
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
			cpage=pageCount;//마지막 페이지 보여주도록
		}
		
		int end=cpage*pageSize;
		int start=end -(pageSize-1);
		//------------------------------------------------------------------
		
		/**게시물 가져오기*/
		List<BoardVO> arr=dao.getSelectedBoard(tnStr, start, end);
		
		/**현재시간과 게시물 작성시간 비교해서 
		 * 오늘작성한 글이라면 시간으로표시하기 (미완성)*/
		long currTimeMillis=System.currentTimeMillis();
		SimpleDateFormat dateForm=new SimpleDateFormat("yyyy-MM-dd");
		String currtime=dateForm.format(currTimeMillis); //현재시간
		
		System.out.println(currtime);
		
		
		/**북마크 여부 가져오기*/
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
		
		/**게시판이름 표시해주기*/
		String tName="";
		switch(tn) {
		case 1:tName="인기";
		break;
		case 2:tName="자유";
		break;
		case 3:tName="유머";
		break;
		case 4:tName="음악";
		break;
		case 5:tName="연예";
		break;
		}
		//-----------------------------------------------------------------
		
		req.setAttribute("BT", arr);
		req.setAttribute("tn", tn);
		req.setAttribute("tName", tName);
		
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("cpage", cpage);
		
		String viewPage="board/board.jsp";
		
		this.setViewPage(viewPage);
		this.setRedirect(false);
		
	}

}
