package com.bootcamp.reactive.reactive.producer.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.reactive.reactive.producer.service.KafkaProducerService;

@RestController
public class BootCampController {

	private KafkaProducerService kafkaProducerService;

	public BootCampController(KafkaProducerService kafkaProducerService) {
		this.kafkaProducerService = kafkaProducerService;
	}

	@GetMapping(value = "/produce/{counter}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public void startFlux(@PathVariable Integer counter) {
		kafkaProducerService.generateMessages(counter);
	}

	@GetMapping(value = "/produce/stop", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public void stopFlux() {
		kafkaProducerService.close();
	}
}