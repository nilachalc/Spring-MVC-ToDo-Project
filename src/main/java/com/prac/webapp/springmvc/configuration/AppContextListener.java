package com.prac.webapp.springmvc.configuration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebListener
public class AppContextListener implements ServletContextListener {

    private AnnotationConfigApplicationContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = new AnnotationConfigApplicationContext();
        context.register(DataSourceConfig.class);
        context.refresh();

        // Optionally, you can add the context to the ServletContext for later retrieval
        sce.getServletContext().setAttribute("springContext", context);

        System.out.println("Spring context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (context != null) {
            context.close();
        }
        System.out.println("Spring context destroyed");
    }
}
