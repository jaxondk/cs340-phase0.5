package server;

import java.io.*;
import java.net.*;
import com.sun.net.httpserver.*;
import server.handlers.CommandHandler;
import server.handlers.parseIntHandler;
import server.handlers.toLCHandler;
import server.handlers.trimHandler;

/**
 * Created by jaxon on 1/17/18.
 */
public class Server
{
        private static final int MAX_WAITING_CONNECTIONS = 12;
        private HttpServer server;

        private void run(String portNumber) {
            System.out.println("Initializing HTTP Server");

            try {
                server = HttpServer.create(
                        new InetSocketAddress(Integer.parseInt(portNumber)),
                        MAX_WAITING_CONNECTIONS);
            }
            catch (IOException e) {
                e.printStackTrace();
                return;
            }

            server.setExecutor(null);

            System.out.println("Creating contexts");
            server.createContext("/toLC", new toLCHandler());
            server.createContext("/trim", new trimHandler());
            server.createContext("/parseInt", new parseIntHandler());
            server.createContext("/command", new CommandHandler());

            System.out.println("Starting server");
            server.start();
            System.out.println("Server started");
        }

        public static void main(String[] args) {
            String portNumber = args[0];
            new Server().run(portNumber);
        }

}
