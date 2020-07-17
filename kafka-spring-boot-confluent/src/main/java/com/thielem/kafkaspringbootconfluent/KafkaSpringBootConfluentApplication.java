package com.thielem.kafkaspringbootconfluent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class KafkaSpringBootConfluentApplication {
	public static void main(String[] args) {
		SpringApplication.run(KafkaSpringBootConfluentApplication.class, args);
	}
}
