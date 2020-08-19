package com.thielem.kafkaspringbootconfluent.handler;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class EventsErrorHandler implements ErrorHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(EventsErrorHandler.class);

    @Override
    public void handle(Exception e, ConsumerRecord<?, ?> consumerRecord) {
        System.out.println("error");
    }


    @Override
    public void handle(Exception thrownException, ConsumerRecord<?, ?> data, Consumer<?, ?> consumer) {
        try{
            LOGGER.info("### INICIO");
            LOGGER.info("### -> Data Key: "  + data.key());
            LOGGER.info("### -> Data Value: "  + data.value());
            LOGGER.info("### -> Data Header: "  + data.headers());
            LOGGER.info("### -> Data LeaderEpoch: "  + data.leaderEpoch());
            LOGGER.info("### -> Data Offset: "  + data.offset());
            LOGGER.info("### -> Data Partition: "  + data.partition());
            LOGGER.info("### -> Data Timestamp: "  + data.timestamp());
            LOGGER.info("### -> Data TimestampType: "  + data.timestampType());
            LOGGER.info("### -> Data Topic: "  + data.topic());
            LOGGER.info("### -> Data ToString: "  + data.toString());
            LOGGER.info("### FIM");
        }catch (Exception e){
            LOGGER.info("### -> ERROR");
            LOGGER.error(e.toString());
        }
    }

    @Override
    public void clearThreadState() {

    }

    @Override
    public boolean isAckAfterHandle() {
        return false;
    }

    @Override
    public void handle(Exception thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer, MessageListenerContainer container) {

    }
}