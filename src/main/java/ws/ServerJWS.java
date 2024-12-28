package ws;

import jakarta.xml.ws.Endpoint;

public class ServerJWS {
    public static void main(String[] args) {
        String url = "http://localhost:8787/";
        Endpoint.publish(url, new BanqueService());
        System.out.println("Server started. Webserver deployed on http://0.0.0.0:8787/");
    }
}
