package com.savushkin.telestream.app.interpreter;

import com.savushkin.telestream.domain.BotCommand;
import com.savushkin.telestream.domain.EventType;
import com.savushkin.telestream.domain.telegram.Update;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UpdateInterpreterServiceImpl implements UpdateInterpreterService {

    @Override
    public EventType interpretUpdate(Update update) {
        if (isCommand(update)) {
            return EventType.COMMAND;
        } else {
            return EventType.TEXT;
        }
    }

    private boolean isCommand(Update update) {
        if (update == null || update.getMessage() == null) {
            return false;
        }
        return Arrays
                .stream(BotCommand.values())
                .anyMatch(bc -> bc.getCommand().equals(update.getMessage().getText()));
    }
}
