package com.chrisnewland.modernrest.webapp;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;

@ServerEndpoint(value = "/websocket")
public class WebsocketServerEndpoint
{
    @OnOpen
    public void onWebSocketConnect(Session session)
    {
        System.out.println("WEBSOCKET CONNECT: " + session.getId());
    }

    @OnMessage
    public void onWebSocketText(Session session, String input) throws IOException
    {
        System.out.println("WEBSOCKET INPUT: " + input + " - FROM: " + session.getId());

        String message = session.getId().substring(0, 6) + ": " + input;
        session.getBasicRemote().sendText(message);
    }

    @OnClose
    public void onWebSocketClose(CloseReason reason)
    {
        System.out.println("WEBSOCKET CLOSED! Reason: " + reason.getReasonPhrase() + " (" + reason.getCloseCode() + ")");
    }

    @OnError
    public void onWebSocketError(Throwable cause)
    {
        if (cause.getMessage() != null)
        {
            System.out.println("WEBSOCKET ERROR: " + cause.getMessage());
        }
    }
}
