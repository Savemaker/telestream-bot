package com.savushkin.telestream.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BotCommand {
    FIND_MOVIE("/find_movie"),
    FIND_SHOW("/find_show"),
    SET_NAME("/set_name"),
    SET_YEAR("/set_year"),
    SET_SEASON("/set_season"),
    SET_EPISODE("/set_episode"),
    RESTART("/restart");

    private final String command;
}
