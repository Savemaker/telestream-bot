package com.savushkin.telestream.app.executor;

import com.savushkin.telestream.domain.BotCommand;
import com.savushkin.telestream.domain.telegram.Update;

public interface CommandStrategyExecutorService {
    void executeCommand(BotCommand botCommand, Update update);
}
