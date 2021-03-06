package com.microserviceshack.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microserviceshack.web.atmosphere.Response;
import org.atmosphere.cpr.BroadcasterFactory;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/client")
public class ClientResource {



    @GET
    public void client(@QueryParam("user") String user) throws JsonProcessingException {

        String msg = new ObjectMapper().writeValueAsString(new Response("admin", "Hello!"));
        BroadcasterFactory.getDefault().lookup("/*").broadcast(msg);

    }


}
