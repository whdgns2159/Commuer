package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class EditArticleAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String tnStr=req.getParameter("tn");
		
		String numStr=req.getParameter("num");
		int num=Integer.parseInt(numStr);
		BoardDAO dao=new BoardDAO();
		BoardVO artInfo=dao.getArticle(tnStr, num);

		req.setAttribute("article", artInfo);
		req.setAttribute("tn", tnStr);
		
		this.setViewPage("board/editArticle.jsp");
		this.setRedirect(false);
		
	}

}
