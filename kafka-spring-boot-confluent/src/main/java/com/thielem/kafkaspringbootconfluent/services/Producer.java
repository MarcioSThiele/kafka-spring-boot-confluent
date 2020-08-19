
package com.thielem.kafkaspringbootconfluent.services;

import com.thielem.kafkaspringbootconfluent.entities.Message;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Producer {

    @Value("${topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplateMessage;

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    public void sendMessage(Message message) {
        String uuid = UUID.randomUUID().toString();
        LOGGER.info(String.format("#### PRODUZINDO -> K: " + uuid + " V:" + message.getMessage()));
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, uuid, message.getMessage());
        this.kafkaTemplateMessage.send(producerRecord);
    }
}


