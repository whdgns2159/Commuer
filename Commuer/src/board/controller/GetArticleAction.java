package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.BoardVO;
import board.model.ReplyVO;
import common.controller.AbstractAction;
import user.model.UserVO;

public class GetArticleAction extends AbstractAction {

	//게시물을 불러와서 내용을 보여주는 액션 (게시글 수정 아님!! 주의!!)
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tn=req.getParameter("tn");
		String numStr=req.getParameter("num");
		int num=Integer.parseInt(numStr);
		
		HttpSession ses=req.getSession();
		UserVO userinfo=(UserVO)ses.getAttribute("loginUser");
		
		String id="";
		if(userinfo!=null) {
			id=userinfo.getId();
		}
		
		BoardDAO dao=new BoardDAO();
		
		dao.increaseHits(tn, num);
		BoardVO article=dao.getArticle(tn, num);
		List<ReplyVO> replyArr=dao.getReply(tn, num);
		int totalReply=dao.totalReply(tn, num);
		
		if(replyArr==null) {
			return;
		}
		req.setAttribute("GA",article);
		req.setAttribute("userid", id);
		req.setAttribute("totalReply", totalReply);
		req.setAttribute("reply", replyArr);
		
		
		req.setAttribute("tn", tn);
		req.setAttribute("num", num);
		//req.setAttribute("GR", replyArr);
		
	
		this.setViewPage("board/article.jsp");
		this.setRedirect(false);

	}

}
