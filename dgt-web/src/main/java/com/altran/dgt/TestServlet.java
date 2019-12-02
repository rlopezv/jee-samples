package com.altran.dgt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.altran.dgt.common.log.LogService;

@SuppressWarnings("serial")
//@WebServlet("/test")
@WebServlet(urlPatterns = {"/test", "/filtered/test"})
public class TestServlet extends HttpServlet {

	static String PAGE_HEADER = "<html><head><title>helloworld</title></head><body>";

	static String PAGE_FOOTER = "</body></html>";

	@Inject
	//@Logger
	LogService LOG;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		LogService.getService().info("begin");
		LOG.info("begin injected");
		PrintWriter writer = resp.getWriter();
		writer.println(PAGE_HEADER);
		writer.println("<h1> HEllo World</h1>");
		writer.println(PAGE_FOOTER);
		writer.close();
		LogService.getService().info("end");
		LOG.info("end injected");
	}

}