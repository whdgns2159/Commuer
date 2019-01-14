package common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import user.model.UserVO;
@WebFilter({"/user/*"})
public class LoginCheckFilter implements Filter{
	
	
	public void destroy() {
		
	}
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession ses=req.getSession();
		UserVO loginUser=(UserVO)ses.getAttribute("loginUser");
		
		if(loginUser==null) {
			req.setAttribute("msg", "�α����� �̿� �����մϴ�");
			req.setAttribute("loc", "javascript:history.back()");
			
			String viewPage="/user/message.jsp";
			RequestDispatcher disp=req.getRequestDispatcher(viewPage);
			disp.forward(req, response);
			return;
		}else {
			//�α����� �����ϰ��
			chain.doFilter(request, response);
			System.out.println("���͸� �Ϸ�");
		}
		
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}