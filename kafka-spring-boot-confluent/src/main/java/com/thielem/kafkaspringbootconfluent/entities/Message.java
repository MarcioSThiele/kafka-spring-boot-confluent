package com.thielem.kafkaspringbootconfluent.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Message {
    private String id;
    private String message;
}
