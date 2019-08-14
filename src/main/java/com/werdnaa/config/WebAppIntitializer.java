package com.werdnaa.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebAppIntitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(SpringConfig.class, WebConfig.class);
        context.setServletContext(servletContext);

        ServletRegistration.Dynamic dispather = servletContext.addServlet("dispather", new DispatcherServlet(context));
        dispather.setLoadOnStartup(1);
        dispather.addMapping("/");

    }
}
