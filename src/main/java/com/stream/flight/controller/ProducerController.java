package com.stream.flight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stream.flight.service.FlightStreamService;

@RestController
public class ProducerController {
	
	
	@Autowired
	FlightStreamService service;
	
	@PostMapping(value="/senddata/{jsonInString}")
	public void setData(@PathVariable final String jsonInString) {
		
		service.sendDataToKafka(jsonInString);
		
	}


}
