package com.chrisnewland.modernrest.webapp;

import com.chrisnewland.freelogj.Logger;
import com.chrisnewland.freelogj.LoggerFactory;

import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;
import java.nio.file.Paths;

public class WebServer
{
	private static Logger logger = LoggerFactory.getLogger(WebServer.class);

	public static void main(String[] args)
	{
		ResourceConfig config = new ResourceConfig();

		String packageWeb = WebServer.class.getPackage()
										   .getName();

		config.packages(packageWeb + ".service");
		config.packages(packageWeb + ".filter");

		URI baseUri = UriBuilder.fromUri("http://localhost/")
								.port(8080)
								.build();

		JettyHttpContainerFactory.createServer(baseUri, config);
	}
}