package com.dirk;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource/<anything>" path)
 */
@Path("myresource/{p}")
public class Resource {

    // A simple example of custom injection
    @Inject
    @Named("FUBAR")
    private String fubar;
    
    // A simple example of field injection
    @PathParam("p")
    private String p;
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String plain() {
        return String.format("fubar was injected with: %s, and %s was requested", fubar, p);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String json() {
        return String.format("{\"%s\":\"%s\"}", fubar, p);
    }
}