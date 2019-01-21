package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import common.controller.AbstractAction;
import user.model.UserVO;

public class DelArticleAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tn=req.getParameter("tn");
		String num=req.getParameter("num");
		String id=req.getParameter("id");
		
		HttpSession ses=req.getSession();
		UserVO userInfo=(UserVO)ses.getAttribute("loginUser");
		BoardDAO dao=new BoardDAO();
		
		int n=0;
		if(userInfo!=null&&userInfo.getId().equals(id.trim())) {
			n=dao.delArticle(tn, num);
		}
		
		String msg=(n>0)?"삭제되었습니다.":"오류발생으로 삭제되지않았습니다.";
		String loc=(n>0)?"board.do?tn="+tn+"&num="+num:"main.do";
		
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		
		this.setViewPage("user/message.jsp");
		this.setRedirect(false);

	}

}
