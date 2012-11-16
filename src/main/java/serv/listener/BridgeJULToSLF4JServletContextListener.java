package serv.listener;

import org.slf4j.bridge.SLF4JBridgeHandler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Handler;
import java.util.logging.LogManager;

/*
 * borrowed from http://blog.cn-consult.dk/2009/03/bridging-javautillogging-to-slf4j.html
 * We want consistent logging output, Jersey uses java.util.logging, this code redirects
 * java.util.logging output to the simple logging facade for java slf4j
 *
 * slf4j can be configured at runtime to write to either log4j or other logging frameworks.
 */
public class BridgeJULToSLF4JServletContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        java.util.logging.Logger rootLogger = LogManager.getLogManager().getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        for (Handler handler : handlers ) {
            rootLogger.removeHandler(handler);
        }
        SLF4JBridgeHandler.install();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // nothing to do
    }

}
