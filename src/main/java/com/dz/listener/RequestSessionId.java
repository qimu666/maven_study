package com.dz.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionIdListener;

public class RequestSessionId implements HttpSessionIdListener {
    @Override
    public void sessionIdChanged(HttpSessionEvent event, String oldSessionId) {
        System.out.println(event.getSession().getId());
//        System.out.println("旧sessionID" + oldSessionId );

    }
}
