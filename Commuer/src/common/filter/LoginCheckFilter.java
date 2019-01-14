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
			req.setAttribute("msg", "로그인후 이용 가능합니다");
			req.setAttribute("loc", "javascript:history.back()");
			
			String viewPage="/user/message.jsp";
			RequestDispatcher disp=req.getRequestDispatcher(viewPage);
			disp.forward(req, response);
			return;
		}else {
			//로그인한 상태일경우
			chain.doFilter(request, response);
			System.out.println("필터링 완료");
		}
		
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		
	}
}