package com.savushkin.telestream.domain.telegram;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InlineKeyboardMarkup {
    @JsonProperty("inline_keyboard")
    List<List<InlineKeyboardButton>> inlineKeyboard;
}
