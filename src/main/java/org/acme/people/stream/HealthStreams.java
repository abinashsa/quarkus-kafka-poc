package org.acme.people.stream;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Produced;



@ApplicationScoped
public class HealthStreams {

   
	  private static final String HEARTRATE_TOPIC = "heartrate";
	  
		  private static final String HEARTRATE_ALERT_TOPIC = "heartratealert";

	    
	    @Produces
	    public Topology buildTopology() {
	    	StreamsBuilder builder = new StreamsBuilder();
	    	
	    	builder.stream(HEARTRATE_TOPIC,Consumed.with(Serdes.String(), Serdes.Integer()))
	    	.filter((name,heartrate)-> heartrate>60)
	    	.to(HEARTRATE_ALERT_TOPIC,Produced.with(Serdes.String(), Serdes.Integer()));
	
	    	return builder.build();
	    }
}