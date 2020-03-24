package com.stream.flight.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class FlightStreamSender {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(FlightStreamSender.class);

  @Autowired
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send(String topic, String payload) {
    kafkaTemplate.send(topic, payload);
  }
}