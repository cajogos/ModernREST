package com.chrisnewland.modernrest.webapp.filter;

import com.chrisnewland.freelogj.Logger;
import com.chrisnewland.freelogj.LoggerFactory;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.ext.Provider;

@Provider
public class RequestFilter implements ContainerRequestFilter
{
	private static Logger logger = LoggerFactory.getLogger(RequestFilter.class);

	@Context private HttpServletRequest servletRequest;

	@Override
	public void filter(ContainerRequestContext request)
	{
		try
		{
			HttpSession session = servletRequest.getSession(true);

			logger.info("got session: {}", session);
		}
		catch (Throwable t)
		{
			logger.error("Could not filter request", t);
		}
	}
}