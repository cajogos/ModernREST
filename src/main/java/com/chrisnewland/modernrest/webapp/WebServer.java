package com.chrisnewland.modernrest.webapp;

import com.chrisnewland.freelogj.Logger;
import com.chrisnewland.freelogj.LoggerFactory;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.session.DefaultSessionCache;
import org.eclipse.jetty.server.session.NullSessionDataStore;
import org.eclipse.jetty.server.session.SessionCache;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

import java.net.InetSocketAddress;
import java.nio.file.Path;
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

		Server server = new Server(new InetSocketAddress("127.0.0.1", 8080));

		ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);

		if (args.length < 1)
		{
			System.err.println("Webserver <resources folder>");
			System.exit(-1);
		}

		Path resourcesBase = Paths.get(args[0]);

		Path staticResourcePath = resourcesBase.resolve("static");

		ServletHolder holderStatic = new ServletHolder("static-home", DefaultServlet.class);

		holderStatic.setInitParameter("resourceBase", staticResourcePath.toString());
		holderStatic.setInitParameter("dirAllowed", "true");
		holderStatic.setInitParameter("pathInfoOnly", "true");

		servletContextHandler.addServlet(holderStatic, "/static/*");

		ServletHolder holderDefault = new ServletHolder("default", DefaultServlet.class);
		servletContextHandler.addServlet(holderDefault, "/");

		ServletHolder servletHolder = new ServletHolder(new ServletContainer(config));

		servletContextHandler.addServlet(servletHolder, "/*");

		SessionHandler sessions = servletContextHandler.getSessionHandler();
		SessionCache cache = new DefaultSessionCache(sessions);
		cache.setSessionDataStore(new NullSessionDataStore());
		sessions.setSessionCache(cache);

		try
		{
			server.start();
			server.join();
		}
		catch (Throwable t)
		{
			t.printStackTrace();
		}
		finally
		{
			server.destroy();
		}
	}
}