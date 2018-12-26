package common.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "*.do" }, 
		initParams = { 
				@WebInitParam(name = "config", 
						value = "C:\\MYJAVA\\Workspace\\Commuer\\WebContent\\WEB-INF\\Command.properties")
		})
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> cmdMap=new HashMap<>();

	public void init(ServletConfig config) throws ServletException {
		String props=config.getInitParameter("config"); 
		Properties pr=new Properties();
		try {
			FileInputStream fis=new FileInputStream(props);
			pr.load(fis);
			if(fis!=null) fis.close();
			//System.out.println(pr.getProperty("/main.do"));
		
			Set<Object> set=pr.keySet();
			
			for(Object key:set) {
				String cmd=key.toString();
				String className=pr.getProperty(cmd);
				System.out.println("cmd="+cmd);
				System.out.println("className="+className);
				if(className!=null) {
					className=className.trim();
					Class cmdClass=Class.forName(className);
					Object cmdInstance=cmdClass.newInstance();
					//ø‰≥¿Ã «ŸΩ…------------------------------------
					cmdMap.put(cmd, cmdInstance); 
					//-----------------------------------------------					
				}
			}//for
			
		}catch(Exception e){
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
	
	private void requestProcess(HttpServletRequest req, HttpServletResponse res) 
	throws IOException,ServletException{
		System.out.println("FrontControllerΩ««‡µ ...");
		
		String uri=req.getRequestURI();
		System.out.println("uri="+uri);
		
		String myctx=req.getContextPath();
		int len=myctx.length();
		String cmd=uri.substring(len);
		Object instance=cmdMap.get(cmd);
		if(instance==null) {
			throw new ServletException(cmd+": æ◊º«¿Ã ≥Œ¿Ãø°ø‰");
		}
		AbstractAction action=(AbstractAction)instance;
		
		try {
			///«ŸΩ…//////////////////////////
			action.execute(req, res);
			//////////////////////////////////
			String viewPage=action.getViewPage();
			if(viewPage==null) {
				System.out.println("∫‰∆‰¿Ã¡ˆ∞° ≥Œ");
				viewPage="test.html";
			}
			if(action.isRedirect()) {
				res.sendRedirect(viewPage);
			}else {
				RequestDispatcher disp=req.getRequestDispatcher(viewPage);
				disp.forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
		
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		requestProcess(request, response);
		
	}
	
}
























