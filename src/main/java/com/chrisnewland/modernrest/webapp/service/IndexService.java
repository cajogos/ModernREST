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
		return "<html><head></head><body><h1>Test</h1></body></html>";
	}
}
