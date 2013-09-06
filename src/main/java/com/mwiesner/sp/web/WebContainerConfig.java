package com.mwiesner.sp.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebContainerConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// No root context needed
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {SpringWebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/rest/*"};
	}

}
