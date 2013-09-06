package com.mwiesner.sp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;

public class WebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {
		DebugServlet debugServlet = new DebugServlet();
		
		Dynamic debugServletConfig = servletContext.addServlet("debugServlet", debugServlet);
		debugServletConfig.addMapping("/debug");
	}

}
