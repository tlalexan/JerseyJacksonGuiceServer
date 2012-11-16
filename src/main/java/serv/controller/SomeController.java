package serv.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class SomeController {

    public SomeController() {
    }

    @GET
    public String getIt() {
        return "hello";
    }

}
