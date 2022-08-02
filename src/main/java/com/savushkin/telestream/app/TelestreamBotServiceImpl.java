package com.savushkin.telestream.app;

import com.savushkin.telestream.app.executor.CommandStrategyExecutorService;
import com.savushkin.telestream.app.executor.TextProcessorService;
import com.savushkin.telestream.app.interpreter.CommandInterpreterService;
import com.savushkin.telestream.app.interpreter.UpdateInterpreterService;
import com.savushkin.telestream.domain.EventType;
import com.savushkin.telestream.domain.telegram.Update;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TelestreamBotServiceImpl implements TelestreamBotService {
    private final UpdateInterpreterService updateInterpreterService;
    private final CommandStrategyExecutorService commandStrategyExecutorService;
    private final CommandInterpreterService commandInterpreterService;
    private final TextProcessorService textProcessorService;

    @Override
    public void processUpdate(Update update) {
        EventType eventType = updateInterpreterService.interpretUpdate(update);
        if (eventType.equals(EventType.COMMAND)) {
            commandStrategyExecutorService.executeCommand(commandInterpreterService.interpretCommand(update), update);
        } else {
            textProcessorService.processText(update);
        }
    }
}
