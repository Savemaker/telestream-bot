package com.savushkin.telestream.app.interpreter;

import com.savushkin.telestream.domain.BotCommand;
import com.savushkin.telestream.domain.telegram.Update;

public interface CommandInterpreterService {
    BotCommand interpretCommand(Update update);
}
