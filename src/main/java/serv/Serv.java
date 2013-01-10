package serv;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.jetty.server.Server;
import org.slf4j.bridge.SLF4JBridgeHandler;
import serv.guice.ServGuiceModule;

import java.util.logging.LogManager;

public class Serv {

    public static void main(String[] args) throws Exception {
        fixLogging();
        Injector injector = Guice.createInjector(new ServGuiceModule());
        Server server = injector.getInstance(Server.class);
        server.start();
        server.join();
    }

    private static void fixLogging() {
        java.util.logging.Logger rootLogger = LogManager.getLogManager().getLogger("");
        java.util.logging.Handler[] handlers = rootLogger.getHandlers();
        for (java.util.logging.Handler handler : handlers) {
            rootLogger.removeHandler(handler);
        }
        SLF4JBridgeHandler.install();
    }

}
