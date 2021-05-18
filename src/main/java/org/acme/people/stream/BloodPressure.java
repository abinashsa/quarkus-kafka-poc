package org.acme.people.stream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

@Path("/bloodpressure")
public class BloodPressure {

	

	@Inject
    @Channel("blood-pressure-stream") Publisher<String> bloodpressure; 

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType("text/plain") 
    public Publisher<String> streamPressure() { 
        return bloodpressure;
    }
}
