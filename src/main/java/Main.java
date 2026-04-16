package com.hotel.booking;

import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws Exception {
        int port = 8085;
        BookingService service = new BookingService();
        
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        
        server.createContext("/status", exchange -> {
            String response = "Available Rooms: " + service.getAvailableRooms().toString();
            exchange.sendResponseHeaders(200, response.length());
            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        System.out.println("Hotel Management Server running on port " + port);
        server.setExecutor(null); 
        server.start();
    }
}