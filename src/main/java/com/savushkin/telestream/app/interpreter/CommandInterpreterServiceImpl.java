package com.savushkin.telestream.app.interpreter;

import com.savushkin.telestream.domain.BotCommand;
import com.savushkin.telestream.domain.telegram.Update;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CommandInterpreterServiceImpl implements CommandInterpreterService {
    @Override
    public BotCommand interpretCommand(Update update) {
        return Arrays
                .stream(BotCommand.values())
                .filter(botCommand -> botCommand.getCommand().equals(update.getMessage().getText()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Unresolved command"));
    }
}
