package com.chrisnewland.modernrest.webapp.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public class IndexService
{
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String index()
	{
		return "<html><head><title>ModernREST</title><link rel=\"stylesheet\" type=\"text/css\" href=\"/static/style.css\"><script src=\"/static/websockets.js\"></script></head><body><h1>It works!</h1></body></html>";
	}
}
