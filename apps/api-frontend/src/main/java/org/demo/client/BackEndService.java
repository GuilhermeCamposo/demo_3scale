package org.demo.client;

import org.demo.entity.Attendee;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import io.quarkus.oidc.client.filter.OidcClientFilter;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import java.util.List;

@OidcClientFilter
@Path("/backend")
@RegisterRestClient()
@Singleton
public interface BackEndService {

    @GET
    List<Attendee> listAll();

    @POST
    Response saveAttendee(Attendee attendee);
  
}
