package serv.guice;


import com.google.inject.servlet.RequestScoped;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import serv.controller.SomeController;

import java.util.Collections;

public class ServGuiceModule extends JerseyServletModule {

    @Override
    protected void configureServlets() {
        bind(SomeController.class).in(RequestScoped.class);
        serve("/*").with(GuiceContainer.class, Collections.<String, String>emptyMap());
    }

}
