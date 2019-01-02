package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class BoardAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String tn=req.getParameter("tn");
		
		BoardDAO dao=new BoardDAO();
		List<BoardVO> arr=dao.getSelectedBoard(tn);
		
		req.setAttribute("BT", arr);
		
		String viewPage="board/board.jsp";
		
		this.setViewPage(viewPage);
		this.setRedirect(false);
		
	}

}
