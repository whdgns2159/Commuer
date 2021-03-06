package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import common.controller.AbstractAction;

public class IncreaseLikesAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tn=req.getParameter("tn");
		String numStr=req.getParameter("num");
		int num=Integer.parseInt(numStr);
		
		BoardDAO dao=new BoardDAO();
		
		int n=dao.increaseLikes(tn, num);
		req.setAttribute("n", n);
		
		this.setViewPage("likeResult.jsp");
		this.setRedirect(false);
	}

}
