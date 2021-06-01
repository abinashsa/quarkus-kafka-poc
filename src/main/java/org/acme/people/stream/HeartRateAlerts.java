package org.acme.people.stream;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import io.smallrye.reactive.messaging.kafka.Record;
@ApplicationScoped
public class HeartRateAlerts {

	
	 @Incoming("heartrate")               
	    @Outgoing("heart-rate-stream")      
	    @Broadcast                       
	    public String process(Record<String, Integer> alert) {
	        
	        return alert.key()+": "+ alert.value()  ;
	    }
}
