package com.demo.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.publisher.Publisher;

@RestController
public class PublisherController {
	protected Logger logger = Logger.getLogger(PublisherController.class.getName());

	private static final String TOPIC = "payload.t";

	@Autowired
	private Publisher pub;

	@RequestMapping("/v1/pub/{text}")
	@ResponseStatus(value = HttpStatus.OK)
	public void postText(@PathVariable("text") String text) {
		logger.info("pub-service getText() invoked: " + text);
		pub.send(TOPIC, text);
	}

	@RequestMapping(value = "/v1/publisher/plain-text", method = RequestMethod.POST, consumes = "text/plain")
	@ResponseStatus(value = HttpStatus.OK)
	public void postPayloadText(@RequestBody String payload) {
		logger.info("pub-service postPayload() invoked: " + payload);
		pub.send(TOPIC, payload);
	}

}
