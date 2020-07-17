package com.thielem.kafkaspringbootconfluent.services;

import com.thielem.Message;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Consumer {
    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private AdminClient adminClient;

    @SneakyThrows
    @KafkaListener(topics = "topic-messages", groupId = "app-group")
    public void handle(ConsumerRecord<String, Message> record){
        //LOGGER.info("### -> Describe Topics: "  + adminClient.describeTopics(Collections.singleton("topic-messages")).all().get().toString());

        //LOGGER.info("### -> Describe Cluster: " + adminClient.describeCluster().nodes().get());
        //LOGGER.info("### -> Describe Cluster: " + adminClient.describeCluster().clusterId().get());
        //LOGGER.info("### -> Describe Cluster: " + adminClient.describeCluster().controller().get());

        LOGGER.info("### CONSUMINDO -> K: " + record.key() + " V: " + record.value());
        throw new Exception("error");
    }
}
