package com.makitoo.java.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by mclement on 5/19/2016.
 */
public class MakitooServletContextListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
            com.makitoo.MakitooJava.init(
                    "https://dashboard.makitoo.com/rest",
                    "APPLICATION_ID",   // Application ID
                    "TOKEN",            // Application token
                    "0.0.1"             // Current version of your application
            );
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
