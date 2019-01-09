package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
import board.model.ReplyVO;
import common.controller.AbstractAction;

public class GetArticleAction extends AbstractAction {

	//�Խù��� �ҷ��ͼ� ������ �����ִ� �׼� (�Խñ� ���� �ƴ�!! ����!!)
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tn=req.getParameter("tn");
		String numStr=req.getParameter("num");
		int num=Integer.parseInt(numStr);
		
		BoardDAO dao=new BoardDAO();
		
		
		BoardVO article=dao.getArticle(tn, num);
		List<ReplyVO> replyArr=dao.getReply(tn, num);
		
		if(replyArr==null) {
			return;
		}
		req.setAttribute("GA",article);
		
		req.setAttribute("tn", tn);
		req.setAttribute("num", num);
		//req.setAttribute("GR", replyArr);
		
		
		this.setViewPage("board/article.jsp");
		this.setRedirect(false);

	}

}
