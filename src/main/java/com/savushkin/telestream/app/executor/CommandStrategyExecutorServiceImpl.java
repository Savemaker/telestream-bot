package com.savushkin.telestream.app.executor;

import com.savushkin.telestream.app.executor.command.CommandExecutor;
import com.savushkin.telestream.domain.BotCommand;
import com.savushkin.telestream.domain.telegram.Update;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class CommandStrategyExecutorServiceImpl implements CommandStrategyExecutorService {
    private final Map<String, CommandExecutor> commandExecutorMap;

    @Override
    public void executeCommand(BotCommand botCommand, Update update) {
        commandExecutorMap.get(botCommand.getCommand()).executeCommand(update);
    }
}
