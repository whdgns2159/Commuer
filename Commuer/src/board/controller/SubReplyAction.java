package board.controller;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import board.model.BoardDAO;
import board.model.ReplyVO;
import common.controller.AbstractAction;

public class SubReplyAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		BoardDAO dao=new BoardDAO();
		HttpSession ses=req.getSession();
		
		if(ses!=null) {
			Enumeration<String> en=ses.getAttributeNames();
			while(en.hasMoreElements()) {
				String key=en.nextElement().toString();
				Object val=ses.getAttribute(key).toString();
				System.out.println(key+"///"+val);
			}
			
		}
		
		String tn=req.getParameter("tn");
		int num=Integer.parseInt(req.getParameter("num"));
		String content=req.getParameter("content");
		
		/*ReplyVO vo=new ReplyVO(0, num, id, content, null);*/
		
		
		
		/*dao.subReply(tn, vo);*/

		this.setViewPage("article.do");
		this.setRedirect(false);
	}

}
