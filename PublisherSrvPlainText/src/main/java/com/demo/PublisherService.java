package com.demo;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PublisherService {
	protected Logger logger = Logger.getLogger(PublisherService.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(PublisherService.class, args);
	}

	// @Autowired
	// private KafkaTemplate<String, String> template;
	//
	// private final CountDownLatch latch = new CountDownLatch(3);
	//
	// //@Override
	// public void run(String... args) throws Exception {
	// this.template.send("myTopic", "foo1");
	// this.template.send("myTopic", "foo2");
	// this.template.send("myTopic", "foo3");
	// latch.await(60, TimeUnit.SECONDS);
	// logger.info("All received");
	// }
	//
	// @KafkaListener(topics = "myTopic")
	// public void listen(ConsumerRecord<?, ?> cr) throws Exception {
	// logger.info(cr.toString());
	// latch.countDown();
	// }
}
