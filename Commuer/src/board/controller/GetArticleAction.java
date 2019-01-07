package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class GetArticleAction extends AbstractAction {

	//게시물을 불러와서 내용을 보여주는 액션 (게시글 수정 아님!! 주의!!)
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tn=req.getParameter("tn");
		String num=req.getParameter("num");
		BoardDAO dao=new BoardDAO();
		
		
		BoardVO vo=dao.getArticle(tn, num);
		
		req.setAttribute("ga", vo);
		
		this.setViewPage("board/article.jsp");
		this.setRedirect(true);

	}

}
