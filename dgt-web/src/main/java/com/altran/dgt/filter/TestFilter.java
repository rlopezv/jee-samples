package com.altran.dgt.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "FooBarFilter", urlPatterns = { "/filtered/*" })
public class TestFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		CharResponseWrapper wrappedResponse = new CharResponseWrapper((HttpServletResponse) response);

		doBeforeProcessing(request, wrappedResponse);
		chain.doFilter(request, wrappedResponse);
		doAfterProcessing(request, wrappedResponse);

		out.write(wrappedResponse.toString());
	}

	@Override
	public void destroy() {
	}

	private void doBeforeProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		try (PrintWriter out = response.getWriter()) {
			out.print("foo--");
			out.flush();
		}
	}

	private void doAfterProcessing(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		try (PrintWriter out = response.getWriter()) {
			out.print("--bar");
			out.flush();
		}
	}

}