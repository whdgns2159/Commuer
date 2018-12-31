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
			//���̵� ����
			req.setAttribute("msg", "���� ���̵��Դϴ�");
			req.setAttribute("loc", "javascript:history.back()");
		}else {
			if(!pwd.equals(uinfo.getPwd())) {
				//��й�ȣ�� Ʋ�����
				req.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
				req.setAttribute("loc", "javascript:history.back()");
			}else {
				//�α����� �Ϸ�Ȱ��
				req.setAttribute("msg", "ȯ���մϴ�.");
				req.setAttribute("loc", "main.do");
				//���ǿ� �α������� ����
				HttpSession hs=req.getSession();
				hs.setAttribute("loginUser", uinfo);
			}
		}
		
		this.setViewPage("user/message.jsp");
		this.setRedirect(false);

	}

}
