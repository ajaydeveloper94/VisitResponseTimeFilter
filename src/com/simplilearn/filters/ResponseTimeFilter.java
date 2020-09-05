package com.simplilearn.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class ResponseTimeFilter
 */
@WebFilter(urlPatterns= {"/mypage1"})
public class ResponseTimeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ResponseTimeFilter() { }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() { }

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter rs = response.getWriter();
		long beforTime = System.currentTimeMillis();
		chain.doFilter(request, response);
		long afterTime = System.currentTimeMillis();
		
		rs.print(" <h1> Total Response Time :-" + ( afterTime - beforTime) +"</h1>");
		rs.close();
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
