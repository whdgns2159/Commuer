package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import common.controller.AbstractAction;
import user.model.UserVO;

public class SetBookmarkAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tn=req.getParameter("tn");
		HttpSession ses=req.getSession();
		
		UserVO vo=(UserVO)ses.getAttribute("loginUser");
		String id="";
		if(vo!=null) {
			id=vo.getId();
		}
		BoardDAO dao=new BoardDAO();
		dao.setBookmark(tn, id);
		
		this.setViewPage("board.do");
		this.setRedirect(false);
	}

}
