package com.demo.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.kafka.publisher.Publisher;
import com.demo.model.Payload;

@RestController
@RequestMapping(value = "/v1/publisher")
public class PublisherController {
	protected Logger logger = Logger.getLogger(PublisherController.class.getName());

	private static final String TOPIC = "payload.t";

	@Autowired
	private Publisher pub;

	 @RequestMapping("/v1/pub/{text}")
	 public String postText(@PathVariable("text") String text) {
		 return "Hello " + text;
	 //logger.info("pub-service getText() invoked: " + text);
//	 pub.send(TOPIC, text);
	 }
	//
	// @RequestMapping(value = "/v1/publisher/text", method = RequestMethod.POST,
	// consumes = "text/plain")
	// public void postPayloadText(@RequestBody String payload) {
	// logger.info("pub-service postPayload() invoked: " + payload);
	// pub.send(TOPIC, payload);
	// }

	@RequestMapping(value = "/json", method = RequestMethod.POST)
	public ResponseEntity<Payload> postPayloadJson(@RequestBody Payload requestBody) {
		// logger.info("PublisherServ postPayloadJson() invoked: " + " TOPIC: [" +
		// requestBody.getTopic() + "] PAYLOAD: [" + requestBody.getPayload() + "]");

		String topic = requestBody.getTopic().isEmpty() ? TOPIC : requestBody.getTopic();
		pub.send(topic, requestBody.getPayload());
		logger.info("PublisherServ kafka send invoked. topic: " + topic);
		return new ResponseEntity<>(requestBody, HttpStatus.OK);
	}
}
