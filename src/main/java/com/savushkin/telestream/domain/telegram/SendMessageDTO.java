package com.savushkin.telestream.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class SendMessageDTO {
    @JsonProperty("chat_id")
    private long chatId;
    private String text;

    public SendMessageDTO(long chatId, String text) {
        this.chatId = chatId;
        this.text = text;
    }
}
