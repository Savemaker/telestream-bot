package com.savushkin.telestream.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InlineKeyboardButton {
    private String text;
    @JsonProperty("web_app")
    private WebAppInfo webAppInfo;
}
