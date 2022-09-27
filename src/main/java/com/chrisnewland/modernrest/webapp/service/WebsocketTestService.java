package com.chrisnewland.modernrest.webapp.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/websocket-test")
public class WebsocketTestService
{
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String display()
    {
        return "<html>" +
                "<head>" +
                "<title>WebSockets - ModernREST</title>" +
                "<link rel=\"stylesheet\" type=\"text/css\" href=\"/static/style.css\">" +
                "<script src=\"/static/websockets.js\"></script>" +
                "</head>" +
                "<body>" +
                "<h1>Websockets Test!</h1>" +
                "<textarea id=\"messages\" rows=\"10\"></textarea>" +
                "<input id=\"message-input\" placeholder=\"Enter your message...\" />" +
                "<button id=\"btn-send\">Send</button>" +
                "</body>" +
                "</html>";
    }
}
