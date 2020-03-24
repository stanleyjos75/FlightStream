package com.stream.flight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stream.flight.constants.Constants;
import com.stream.flight.consumer.FlightStreamConsumer;
import com.stream.flight.sender.FlightStreamSender;

@Service
public class FlightStreamService {

	@Autowired
	private FlightStreamSender sender;
	
	@Autowired
	private FlightStreamConsumer consumer;

	public void sendDataToKafka(String jsonInString) {
		try {
			sender.send(Constants.TOPIC_NAME, jsonInString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
