package com.thielem.kafkaspringbootconfluent.beans;

import com.thielem.kafkaspringbootconfluent.handler.EventsErrorHandler;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

@Configuration
@RequiredArgsConstructor
public class KafkaConsumerConfig {

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>> listenerContainerFactoryBean(ConsumerFactory<String, Object> consumerFactory, EventsErrorHandler eventsErrorHandler){

        ConcurrentKafkaListenerContainerFactory<String, Object> containerFactory = new ConcurrentKafkaListenerContainerFactory<>();

        containerFactory.setConsumerFactory(consumerFactory);
        //containerFactory.setConcurrency(20);
        //containerFactory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        //containerFactory.getContainerProperties().setPollTimeout(1);
        containerFactory.setErrorHandler(eventsErrorHandler);

        return containerFactory;
    }

    @Bean
    AdminClient adminClient(ConsumerFactory<String, Object> consumerFactory){
        AdminClient admin = KafkaAdminClient.create(consumerFactory.getConfigurationProperties());
        return admin;
    }
}
