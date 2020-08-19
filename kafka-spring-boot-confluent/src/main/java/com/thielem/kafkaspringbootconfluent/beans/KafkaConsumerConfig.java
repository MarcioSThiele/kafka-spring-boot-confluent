package com.thielem.kafkaspringbootconfluent.beans;

import com.thielem.kafkaspringbootconfluent.handler.EventsErrorHandler;
import lombok.RequiredArgsConstructor;
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
        containerFactory.setErrorHandler(eventsErrorHandler);

        return containerFactory;
    }
}
