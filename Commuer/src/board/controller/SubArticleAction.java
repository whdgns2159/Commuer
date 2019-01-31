package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;
import user.model.UserVO;

public class SubArticleAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//세션에서 유저정보 가져오기
		HttpSession ses=req.getSession();
		Object uinfo=ses.getAttribute("loginUser");
		if(uinfo==null) {
			req.setAttribute("msg","로그인 해야 이용 가능해요");
			String loc="javascript:history.back()";
			req.setAttribute("loc", loc);
			this.setViewPage("user/message.jsp");
			this.setRedirect(false);
			return;
		}
		UserVO userInfo=(UserVO)uinfo;
		
		//게시판넘버 가져오기
		String tnStr=req.getParameter("tn");
		
		BoardDAO dao=new BoardDAO();
		
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		String contents = content.replace("\r\n", "<br>"); //엔터키
		String id=userInfo.getId();
		
		System.out.println("subject:"+subject+"content: "+contents+"id: "+id);
				
		BoardVO article=new BoardVO(0 , subject, contents, id, 0, 0, null);
		int n=0;
		//게시판번호, 
		for(int i=0;i<50;i++) {
			n=dao.insertBoard(tnStr, article);
		}
		String msg=(n>0)?"작성되었습니다.":"작성에 실패했습니다.";
		String loc=(n>0)?"main.do":"javascript:history.back()";
		
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		this.setViewPage("user/message.jsp");
		this.setRedirect(false);
	}

}
