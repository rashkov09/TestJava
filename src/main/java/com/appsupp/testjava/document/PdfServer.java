package com.appsupp.testjava.document;

import java.io.*;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.springframework.stereotype.Component;

@Component
public class PdfServer {

    public void startServer() {
        try {
            HttpServer server = HttpServer.create(new java.net.InetSocketAddress(8000), 0);
            server.createContext("/user-agreement", new HtmlHandler());
            server.setExecutor(null); // creates a default executor
            server.start();
            System.out.println("Server started on port 8000");
        } catch (Exception e) {
            System.out.println("Error starting server: " + e.getMessage());
        }
    }

    static class HtmlHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            System.out.println("Received request for user-agreement.html");
            String filePath = "src/main/resources/templates/user-agreement.html";
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("File not found: " + filePath);
                t.sendResponseHeaders(404, 0);
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line).append("\n");
            }

            if (response.length() > 500) {
                response = new StringBuilder(); // Clear the response if it's too long
            }
            reader.close();
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
            System.out.println("Sent response for user-agreement.html");
        }
    }
}