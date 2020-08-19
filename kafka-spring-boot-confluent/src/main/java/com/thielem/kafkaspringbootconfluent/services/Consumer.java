
package com.thielem.kafkaspringbootconfluent.services;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Consumer {

    //@Value("${topic.name}")
    //private static String TOPIC;

    //@Value("${group.id}")
    //private static String GROUP_ID;

    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "topic-tef", groupId = "app-group")
    public void handle(ConsumerRecord<String, String> record){
        LOGGER.info("### CONSUMINDO -> K: " + record.key() + " V: " + record.value());
    }
}
