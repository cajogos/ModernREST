package com.chrisnewland.modernrest.webapp;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;

@ServerEndpoint(value = "/chat")
public class WebsocketServerEndpoint
{
    @OnOpen
    public void onWebSocketConnect(Session session)
    {
        System.out.println("welcome my dude");
    }

    @OnMessage
    public void onWebSocketText(Session session, String input) throws IOException
    {
        System.out.println("input:" + input);
        session.getBasicRemote().sendText("thanks for " + input);
    }

    @OnClose
    public void onWebSocketClose(CloseReason reason)
    {
        System.out.println("Socket Closed: " + reason);
    }

    @OnError
    public void onWebSocketError(Throwable cause)
    {
        if (cause.getMessage() != null)
        {
            System.out.println("onWebSocketError: " + cause.getMessage());
        }
    }
}
