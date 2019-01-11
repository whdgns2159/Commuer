package user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.UserVO;

public class TopUserAdjustAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession ses=req.getSession();
		UserVO userinfo=(UserVO)ses.getAttribute("loginUser");
		
		req.setAttribute("currentUInfo", userinfo);
		
		this.setViewPage("/user/userAdjust.jsp");
		this.setRedirect(false);

	}

}
