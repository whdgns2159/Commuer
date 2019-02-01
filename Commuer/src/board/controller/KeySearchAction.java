package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDAO;
import board.model.BoardVO;
import common.controller.AbstractAction;

public class KeySearchAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession ses=req.getSession();
		String keyword=req.getParameter("keyword");
		if(keyword==null||keyword.trim().isEmpty()) {
			keyword=(String)ses.getAttribute("keyword");			
		}
		ses.setAttribute("keyword",keyword);
		String tn=req.getParameter("tn");
		
		BoardDAO dao=new BoardDAO();
		/**페이징 처리하기*/
		
		String cpStr=req.getParameter("cpage");
		int pagingBlock=10;
		int prevBlock=0;
		int nextBlock=0;
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

		prevBlock=(cpage-1)/pagingBlock*pagingBlock;
		nextBlock=prevBlock+(pagingBlock+1);

		
		int end=cpage*pageSize;
		int start=end -(pageSize-1);
		

		StringBuilder buf=new StringBuilder().append("<ul class='pagination'>");
		
		if(prevBlock>0){
			buf.append("<li><a class='page-link' href='keywordSearch.do?tn="+tn+"&cpage="+prevBlock+"&keyword="+keyword+"'>");
			buf.append("Prev");
			buf.append("</a></li>");
		}
		for(int i=prevBlock+1;i<=nextBlock-1&& i<=pageCount;i++){
			String css="";
			if(i==cpage) {
				css="class='active'";
			}
			buf.append("<li "+css+"><a class='page-link' href='keywordSearch.do?tn="+tn+"&cpage="+i+"&keyword="+keyword+"'>"+i+"</a>");
			buf.append("</li>");
		}
		if(nextBlock<pageCount){
			buf.append("<li><a class='page-link' href='keywordSearch.do?tn="+tn+"&cpage="+nextBlock+"&keyword="+keyword+"'>");
			buf.append("Next");
			buf.append("</a></li>");
		}
		buf.append("</ul>");
		String pagination=buf.toString();
		
		//------------------------------------------------------------------

		
		List<BoardVO> searchResult=dao.keywordSearch(tn, keyword, start, end);
		
		req.setAttribute("BS", searchResult);
		req.setAttribute("SearchPagination", pagination);
		this.setViewPage("board/boardSearch.jsp");
		this.setRedirect(false);

	}

}
