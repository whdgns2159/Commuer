package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.UserDAO;
import user.model.UserVO;

public class UserAdjustAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession ses=req.getSession();
		
		UserVO userinfo=(UserVO)ses.getAttribute("loginUser");
		
		String id=userinfo.getId();
		
		String nick=req.getParameter("userNick");
		String pwd=req.getParameter("userPwd");
		String email=req.getParameter("userEmail");
		String tel=req.getParameter("userTel");
		
		UserVO vo=new UserVO(0, id, pwd,nick, email, tel, null);
		
		UserDAO dao=new UserDAO();
		int n=dao.userAdjust(vo);
		
		String msg=(n>0)?"수정완료":"수정실패";
		String loc=(n>0)?"main.do":"javascript:history.back()";
		
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
		
		this.setViewPage("/user/message.jsp");
		this.setRedirect(false);

	}

}
