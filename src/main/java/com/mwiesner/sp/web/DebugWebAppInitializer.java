package com.mwiesner.sp.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;

public class DebugWebAppInitializer{

	public void onStartup(ServletContext servletContext)
			throws ServletException {
		DebugServlet debugServlet = new DebugServlet();
		
		Dynamic debugServletConfig = servletContext.addServlet("debugServlet", debugServlet);
		debugServletConfig.addMapping("/debug");
	}

}
