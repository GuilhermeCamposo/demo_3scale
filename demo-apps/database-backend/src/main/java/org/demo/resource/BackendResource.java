package org.demo.resource;

import java.util.List;

// import javax.annotation.security.RolesAllowed;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.demo.entity.Attendee;


@Path("/backend")
public class BackendResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Attendee> listAttendees() {
        return Attendee.listAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    // @RolesAllowed("authorized")
    @Transactional
    public  Response saveAttendee(Attendee attendee) {
        attendee.persist();
        return Response.created(null).build();
    }

}
