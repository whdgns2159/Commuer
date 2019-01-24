package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.model.UserVO;

public class MainAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		
		HttpSession ses=req.getSession();
		if(ses!=null) {
			UserVO userinfo=new UserVO();
			userinfo=(UserVO)ses.getAttribute("loginUser");
			String admin="aa";
			
			if(userinfo.getId().equals(admin)) {
				req.setAttribute("loginUser", userinfo);
			}
			
		}
		
		this.setViewPage("main.jsp");
		this.setRedirect(false);
	}

}
