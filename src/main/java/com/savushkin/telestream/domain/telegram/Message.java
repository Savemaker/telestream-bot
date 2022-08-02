package com.savushkin.telestream.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @JsonProperty("message_id")
    private long messageId;
    private Chat chat;
    private String text;
}
