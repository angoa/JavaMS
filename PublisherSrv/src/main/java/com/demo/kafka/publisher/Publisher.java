package com.demo.kafka.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.demo.model.JsonObject;

public class Publisher {

	private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);

	@Autowired
	private KafkaTemplate<String, JsonObject> kafkaTemplate;

	public void send(String topic, JsonObject payload) {
		LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
		kafkaTemplate.send(topic, payload);
	}
}