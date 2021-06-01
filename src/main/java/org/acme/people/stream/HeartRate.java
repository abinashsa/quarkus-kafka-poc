package org.acme.people.stream;



import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.reactivestreams.Publisher;



/**
 * A simple resource retrieving the in-memory "my-data-stream" and sending the items as server-sent events.
 */
@Path("/heartrate-alert")
public class HeartRate {

	// getting values from in memory stream
    @Inject
    @Channel("heart-rate-stream") 
    Publisher<String> heartrate; 

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Publisher<String> stream() { 
    	
        return heartrate;
    }
}