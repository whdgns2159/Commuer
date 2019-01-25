package board.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import common.controller.AbstractAction;

public class EditEndArticleAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String sub=req.getParameter("subject");
		String cont=req.getParameter("content");
		String num=req.getParameter("num");
		String tnStr=req.getParameter("tn");
		
		Map<String, String> map=new HashMap<>();
		
		map.put("sub", sub);
		map.put("cont", cont);
		map.put("num", num);
		
		BoardDAO dao=new BoardDAO();
		int n=dao.editArticle(tnStr, map);
		
		String msg=(n>0)?"작성글이 수정되었습니다.":"알수없는 오류로 인해 수정실패";
		String loc="board.do?tn="+tnStr;
		
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		this.setViewPage("user/message.jsp");
		this.setRedirect(false);
		
	}

}
