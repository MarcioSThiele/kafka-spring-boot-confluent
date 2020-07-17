package com.thielem.kafkaspringbootconfluent.beans;

import com.thielem.Message;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaTemplateConfig {
    @Bean
    KafkaTemplate<String, Message> kafkaTemplateGenericRecordBean(ProducerFactory<String, Message> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
