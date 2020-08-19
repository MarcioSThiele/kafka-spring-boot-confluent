
package com.thielem.kafkaspringbootconfluent.controller;


import com.thielem.kafkaspringbootconfluent.entities.Message;
import com.thielem.kafkaspringbootconfluent.services.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class KafkaController {

    @Autowired
    private Producer producer;

    @PostMapping(value = "/publish")
    public HttpStatus sendMessageToKafkaTopic(@RequestBody Message message) {
        this.producer.sendMessage(message);
        return HttpStatus.OK;
    }
}

