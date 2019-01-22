package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class KeySearchAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String keyword=req.getParameter("keyword");
		String tn=req.getParameter("tn");
		
		BoardDAO dao=new BoardDAO();
		/**페이징 처리하기*/
		
		String cpStr=req.getParameter("cpage");
		if(cpStr==null||cpStr.trim().isEmpty()) {
			cpStr="1";
		}

		int cpage=Integer.parseInt(cpStr);
		if(cpage<=0) {
			cpage=1;
		}
		
		int totalCount=dao.getKeywordCount(tn, keyword);
		int pageSize=10;
		int pageCount=0;
		
		pageCount=(totalCount-1)/pageSize+1;
		
		if(cpage>pageCount) {
			cpage=pageCount;//마지막 페이지 보여주도록
		}
		
		int end=cpage*pageSize;
		int start=end -(pageSize-1);
		//------------------------------------------------------------------

		
		List<BoardVO> searchResult=dao.keywordSearch(tn, keyword, start, end);
		
		req.setAttribute("Ba", searchResult);

	}

}
