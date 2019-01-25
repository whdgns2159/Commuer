package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.UserVO;


public class LogoutAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession ses=req.getSession();
		UserVO userinfo=new UserVO();
		userinfo=(UserVO)ses.getAttribute("loginUser");
		if(userinfo!=null) {
			ses.invalidate();
		}
		
		this.setViewPage("main.do");
		this.setRedirect(false);
	}

}
