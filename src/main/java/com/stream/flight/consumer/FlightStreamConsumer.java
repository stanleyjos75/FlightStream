package com.stream.flight.consumer;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.stream.flight.constants.Constants;
import com.stream.flight.service.FlightStreamService;

public class FlightStreamConsumer {

	@Autowired
	FlightStreamService consumeService;
	
	private CountDownLatch latch = new CountDownLatch(1);
	public CountDownLatch getLatch() {
		return latch;
	}

	@KafkaListener(topics = Constants.TOPIC_NAME)
	public void receiveMessage(String payload) {
		
		try {
			System.out.println(" receiveMessage : : "+payload);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		latch.countDown();
	}

	
}
