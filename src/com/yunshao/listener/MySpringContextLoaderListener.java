package com.yunshao.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MySpringContextLoaderListener implements ServletContextListener
{

    public static final String WEB_APPLICATION_CONTEXT_ATTRIBUTE = MySpringContextLoaderListener.class.toString();

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        System.out.println("-------begin---------");
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        servletContextEvent.getServletContext().setAttribute(WEB_APPLICATION_CONTEXT_ATTRIBUTE , ac);
        System.out.println("-------end---------");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
