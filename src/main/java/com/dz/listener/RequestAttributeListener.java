package com.dz.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class RequestAttributeListener implements ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        String name = srae.getName();
        Object value = srae.getValue();
        System.out.println(name+value+"创建");

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        Object value = srae.getValue();
        System.out.println(value+"删除");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        System.out.println(srae.getName() + "新值" + srae.getValue());
    }
}
