package com.bootcamp.reactive.reactive.producer.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderRecord;

@Service
public class KafkaProducerService {

	private final KafkaSender<String, String> sender;

	@Value("${kafka.topic}")
	private String topic;

	public KafkaProducerService(KafkaSender<String, String> sender) {
		this.sender = sender;
	}

	public void close() {
		sender.close();
	}

	public void generateMessages(int count) {
		sender.send(Flux.range(1, count)
				.map(i -> SenderRecord.create(new ProducerRecord<>(topic, "Key_" + i, "Message_" + i), i)))
				.subscribe();
	}
}