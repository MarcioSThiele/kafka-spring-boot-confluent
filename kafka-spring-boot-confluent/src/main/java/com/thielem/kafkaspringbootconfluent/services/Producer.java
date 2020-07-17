package com.thielem.kafkaspringbootconfluent.services;

import com.thielem.Message;
import lombok.SneakyThrows;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    @Value("${producer.topic.name}")
    private String topic;

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplateMessage;

    private static int COUNT=0;
    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @SneakyThrows
    public void sendMessage(String message) {
        LOGGER.info(String.format("#### PRODUZINDO -> " + message));
        Message avroMessage = Message.newBuilder().setMessage(message).build();
        ProducerRecord<String, Message> producerRecord = new ProducerRecord<>(topic, String.valueOf(COUNT), avroMessage);
        this.kafkaTemplateMessage.send(producerRecord);
        COUNT++;
    }
}
