package com.shanghai.our.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class SessionFilter implements Filter{
	public void destroy() {  
        // TODO Auto-generated method stub  
          
    }  
  
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {  
        // TODO Auto-generated method stub  
        HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) res;  
        // 如果session不为空，则可以浏览其他页面  
        String url = request.getServletPath();  
        //这里判断目录，后缀名，当然也可以写在web.xml中，用url-pattern进行拦截映射  
        if (url.contains("/login.jsp"))  
                {  
                 response.setContentType("text/html;charset=UTF-8");  
                 PrintWriter out = response.getWriter();  
                 out.println("<script language='javascript' type='text/javascript'>");  
                 out.println("parent.location.href='" + request.getContextPath() + "/login.action'");  
                 out.println("</script>");  
        } else {  
        	 response.setContentType("text/html;charset=UTF-8");  
             PrintWriter out = response.getWriter();  
             out.println("<script language='javascript' type='text/javascript'>");  
             out.println("parent.location.href='" + request.getContextPath() + "/login.action'");  
             out.println("</script>");  
        }  
    }  
  
    public void init(FilterConfig arg0) throws ServletException {  
        // TODO Auto-generated method stub  
  
    }  
}
