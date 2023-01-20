package org.demo.resource;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.demo.client.BackEndService;
import org.demo.entity.Attendee;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("/frontend")
public class FrontEndResource {

    @Inject
    @RestClient
    BackEndService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Attendee> listAttendees() {
        return service.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public  Response  saveAttendee(Attendee attendee) {
        
        return service.saveAttendee(attendee);
    }

}