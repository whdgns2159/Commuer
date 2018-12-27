package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import user.model.UserDAO;
import user.model.UserVO;

public class UserCreateAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		String id=req.getParameter("userId");
		String pwd=req.getParameter("userPwd");
		String nickname=req.getParameter("userNick");
		String email=req.getParameter("userEmail");
		String tel=req.getParameter("userTel");
		
		
		UserVO uvo=new UserVO(0, id, pwd, nickname, email, tel, null);
		
		UserDAO dao=new UserDAO();
		int n=dao.createUser(uvo);
		
		String str=(n>0)?"계정 생성 성공":"계정 생성 실패";
		String loc=(n>0)?"main.do":"javascript:history.back()";
		
		req.setAttribute("msg", str);
		req.setAttribute("loc", loc);
		
		this.setRedirect(true);
		this.setViewPage("../user/message.jsp");
	}

}
