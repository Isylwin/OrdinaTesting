package nl.earthbird;

import org.glassfish.jersey.client.ClientConfig;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class Company {

    private Client client;

    private Developer javaDeveloper;

    public Company(Developer developer) {
        this.javaDeveloper = developer;
        ClientConfig config = new ClientConfig();
        client = ClientBuilder.newClient(config);
    }

    public String send(final Contractor contractor) {
        final WebTarget wegTarget = this.client
                .target("http://localhost:8888/{contractor}")
                .resolveTemplate("contractor", contractor.getName());
        final Response response = wegTarget
                .request("application/json")
                .post(Entity.json(this.javaDeveloper), Response.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("HTTP Response: " + response.getStatus());
        }
        return response.readEntity(String.class);
    }
}
