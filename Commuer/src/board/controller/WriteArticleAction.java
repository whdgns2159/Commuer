package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class WriteArticleAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tn=req.getParameter("tn");
		
		req.setAttribute("tn", tn);
		
		this.setViewPage("board/articleWrite.jsp");
		this.setRedirect(false);
	}

}
