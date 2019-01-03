package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;
import user.model.UserVO;

public class SubArticleAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//���ǿ��� �������� ��������
		HttpSession ses=req.getSession();
		Object uinfo=ses.getAttribute("uinfo");
		
		UserVO userInfo=(UserVO)uinfo;
		
		//�Խ��ǳѹ� ��������
		String tnStr=req.getParameter("tn");
		
		BoardDAO dao=new BoardDAO();
		
		String subject=req.getParameter("subject");
		String content=req.getParameter("content");
		String id=userInfo.getId();
		
				
		BoardVO article=new BoardVO(0 , subject, content, id, 0, 0, null);
		
		//�Խ��ǹ�ȣ, 
		int n=dao.insertBoard(tnStr, article);
		
		String msg=(n>0)?"�ۼ��Ǿ����ϴ�.":"�ۼ��� �����߽��ϴ�.";
		String loc=(n>0)?"main.do":"javascript:history.back()";
		
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		this.setViewPage("user/message.jsp");
		this.setRedirect(false);
	}

}
