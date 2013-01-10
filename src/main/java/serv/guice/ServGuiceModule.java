package serv.guice;


import com.google.inject.Provides;
import com.google.inject.servlet.GuiceFilter;
import com.google.inject.servlet.RequestScoped;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import serv.controller.SomeController;

import javax.inject.Singleton;
import javax.servlet.DispatcherType;
import java.util.Collections;
import java.util.EnumSet;

public class ServGuiceModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {
        bind(SomeController.class).in(RequestScoped.class);
        serve("/*").with(GuiceContainer.class, Collections.<String, String>emptyMap());
    }

    @Provides
    @Singleton
    private Server jettyServer() {
        Server server = new Server(8080);

        FilterHolder filterHolder = new FilterHolder(GuiceFilter.class);
        filterHolder.setName("guice");

        ServletContextHandler servletContextHandler = new ServletContextHandler(server, "/");
        servletContextHandler.addFilter(filterHolder, "/*", EnumSet.allOf(DispatcherType.class));
        servletContextHandler.addServlet(DefaultServlet.class, "/");
        server.setHandler(servletContextHandler);

        return server;
    }
}
