package user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import user.model.UserDAO;
import user.model.UserVO;

public class TopUserAdjustAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession ses=req.getSession();
		UserVO userinfo=(UserVO)ses.getAttribute("loginUser");
		
		//현재 회원 목록 불러오기
		UserDAO dao=new UserDAO();
		List<UserVO> userList=dao.getUserList();
		
		req.setAttribute("userlist", userList);
		req.setAttribute("currentUInfo", userinfo);
		
		this.setViewPage("/user/userAdjust.jsp");
		this.setRedirect(false);

	}

}
