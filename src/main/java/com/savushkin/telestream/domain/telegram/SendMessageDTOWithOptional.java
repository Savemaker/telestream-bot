package com.savushkin.telestream.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SendMessageDTOWithOptional extends SendMessageDTO {
    @JsonProperty("reply_markup")
    private InlineKeyboardMarkup inlineKeyboardMarkup;

    public SendMessageDTOWithOptional(long chatId, String text, InlineKeyboardMarkup inlineKeyboardMarkup) {
        super(chatId, text);
        this.inlineKeyboardMarkup = inlineKeyboardMarkup;
    }
}
