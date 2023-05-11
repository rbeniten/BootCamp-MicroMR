package com.bootcamp.reactive.reactive.producer.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.kafka.sender.KafkaSender;
import reactor.kafka.sender.SenderOptions;

@Configuration
public class KafkaConfig {

	@Value("${kafka.topic}")
	private String topic;
	
	@Value("${kafka.server}")
	private String server;

	@Value("${kafka.client_id}")
	private String clientID;

	@Value("${kafka.group_id}")
	private String groupID;

	@Bean
	public KafkaSender<String, String> kafkaSender() {

		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, server);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, clientID);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		SenderOptions<String, String> senderOptions = SenderOptions.create(props);

		return KafkaSender.create(senderOptions);
	}
}