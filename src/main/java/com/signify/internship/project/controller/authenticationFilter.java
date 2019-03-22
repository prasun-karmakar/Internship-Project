package com.signify.internship.project.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class authenticationFilter
 */
@WebFilter("/authenticationFilter")
public class authenticationFilter implements Filter {
	private ServletContext context;
    /**
     * Default constructor. 
     */
	public void init(FilterConfig fConfig) throws ServletException {

		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");

	}
    public authenticationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		this.context.log("Requested Resource::"+uri);
		
		HttpSession session = req.getSession(false);
    	//String name = (String) session.getAttribute("username");

		/* if(session != null){
			 
			 System.out.println(session);
			 chain.doFilter(request, response);
	
		}else{
			// pass the request along the filter chain
			 
				this.context.log("Unauthorized access request");
				res.sendRedirect("login.jsp");
		
		}
	*/	    
	}
}	

	


