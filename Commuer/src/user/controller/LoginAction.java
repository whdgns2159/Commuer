package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.UserDAO;
import user.model.UserVO;

public class LoginAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id=req.getParameter("id");
		String pwd=req.getParameter("pwd");
		
		UserDAO dao=new UserDAO();
		UserVO uinfo=dao.userLogin(id);
		
		if(uinfo==null) {
			//아이디가 없다
			req.setAttribute("msg", "없는 아이디입니다");
			req.setAttribute("loc", "javascript:history.back()");
		}else {
			if(!pwd.equals(uinfo.getPwd())) {
				//비밀번호가 틀린경우
				req.setAttribute("msg", "비밀번호가 틀렸습니다.");
				req.setAttribute("loc", "javascript:history.back()");
			}else {
				//로그인이 완료된경우
				req.setAttribute("msg", "환영합니다.");
				req.setAttribute("loc", "main.do");
				//세션에 로그인정보 저장
				HttpSession hs=req.getSession();
				hs.setAttribute("loginUser", uinfo);
			}
		}
		
		this.setViewPage("user/message.jsp");
		this.setRedirect(false);

	}

}
