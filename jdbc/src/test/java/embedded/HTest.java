package embedded;

import org.h2.server.ShutdownHandler;
import org.h2.tools.Server;

/**
 * @author he
 * @since 2015/1/24
 */
public class HTest {

    public static void main(String[] args) throws Exception {
        final Server webServer = Server.createWebServer();
        webServer.start();

        System.in.read();
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                webServer.shutdown();
            }
        }));
    }
}
