package org.stoeckmann.citm;

import java.io.IOException;
import java.net.URI;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Main class.
 *
 */
public class Main {
    public static final String BASE_URI = "http://localhost:8080/citm/";

    static EntityManagerFactory factory;

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
     * application.
     * 
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        final ResourceConfig rc = new ResourceConfig().packages("org.stoeckmann.citm");
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    static EntityManagerFactory getFactory() {
        return factory;
    }

    /**
     * Main method.
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        factory = Persistence.createEntityManagerFactory("citm");

        final HttpServer server = startServer();
        System.out.println("Press enter to stop application");
        System.in.read();
        server.stop();
    }
}
