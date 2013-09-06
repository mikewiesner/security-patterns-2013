package com.mwiesner.sp;

import java.io.IOException;
import java.net.URL;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.io.FilenameUtils;

public class DebugServlet implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		String path = req.getParameter("path");
		URL resource = req.getServletContext().getResource(path);
		if (path.endsWith("/")) {
			res.getOutputStream().print("Returning directory listing:\r\n\r\n");
			Set<String> resourcePaths = req.getServletContext().getResourcePaths(path);
			res.getOutputStream().print(resourcePaths.toString());
		}
		else if (resource != null) {
			req.getRequestDispatcher(path).forward(req, res);
		}
		else {
			res.getOutputStream().print("File not found, returning content of parent folder:\r\n\r\n");
			String parentFolder = FilenameUtils.getPath(path);
			Set<String> resourcePaths = req.getServletContext().getResourcePaths("/"+parentFolder);
			res.getOutputStream().print(resourcePaths.toString());
		}
		
		
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void destroy() {
		
	}

}
