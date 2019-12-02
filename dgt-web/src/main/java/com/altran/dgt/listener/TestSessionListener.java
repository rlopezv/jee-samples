package com.altran.dgt.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.altran.dgt.common.cdi.Logger;
import com.altran.dgt.common.log.LogService;

@WebListener
public class TestSessionListener implements HttpSessionListener, ServletContextListener {

	@Logger
	private LogService LOG;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		getService().info("Created: {}", se.getSession());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		getService().info("Destroyed: {}", se.getSession());
	}

	private LogService getService() {
		if (null==LOG) {
			LOG = LogService.getService();
		}
		return LOG;
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		getService().info("Created Ctx: {}", sce.getServletContext().getContextPath());

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		getService().info("Destroyed Ctx: {}", sce.getServletContext().getContextPath());

	}
}