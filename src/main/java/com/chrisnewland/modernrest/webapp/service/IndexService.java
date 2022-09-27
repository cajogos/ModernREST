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
		return "<html><head><link rel=\"stylesheet\" type=\"text/css\" href=\"/static/style.css\"></head><body><h1>It works!</h1></body></html>";
	}
}
