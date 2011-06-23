package org.softlang.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class RequestUtil {
	
	public static String getRequestParameter(String name) {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		return request.getParameter(name);
	}
	
	public static Object getSessionValue(String name) {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
	
		return request.getSession().getAttribute(name);
	}
	
	public static void setSessionValue(String name, Object value) {
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		
		request.getSession().setAttribute(name, value);
	}
}
