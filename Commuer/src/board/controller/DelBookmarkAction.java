package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import common.controller.AbstractAction;
import user.model.UserVO;

public class DelBookmarkAction extends AbstractAction {


	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession ses=req.getSession();
		UserVO userInfo=(UserVO)ses.getAttribute("loginUser");
		
		String tn=req.getParameter("tn");
		String id=userInfo.getId();
		
		BoardDAO dao=new BoardDAO();
		dao.delBookmark(id, tn);

	}

}
