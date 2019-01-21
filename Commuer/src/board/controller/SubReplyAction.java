package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.ReplyVO;
import common.controller.AbstractAction;
import user.model.UserVO;

public class SubReplyAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		BoardDAO dao=new BoardDAO();
		HttpSession ses=req.getSession();
		UserVO loginUser=(UserVO)ses.getAttribute("loginUser");
		int n=0;
		String tn="";
		int num=0;
		if(loginUser!=null) {
	
			tn=req.getParameter("tn");
			num=Integer.parseInt(req.getParameter("num"));
			String content=req.getParameter("content");
			String id=loginUser.getId();
			
			ReplyVO vo=new ReplyVO(0, num, id, content, null);
			 n=dao.subReply(tn, vo);
			
		}
		String msg=(n>0)?"댓글입력완료":"댓글입력 실패";
		String loc=(n>0)?"article.do?tn="+tn+"&num="+num:"javascript:history.back()";
		
		
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		this.setViewPage("/user/message.jsp");
		this.setRedirect(false);
	}

}
