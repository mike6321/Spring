package me.choi;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Project : servlet-core
 * Created by InteliJ IDE
 * Developer : junwoochoi
 * Date : 2020/04/12
 * Time : 4:42 오후
 */
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ContectInitialized");
        sce.getServletContext().setAttribute("name", "junwoo");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
    }
}
