package com.savushkin.telestream.app.executor.command;

import com.savushkin.telestream.app.repository.StreamRepository;
import com.savushkin.telestream.app.sender.ResponseSenderService;
import com.savushkin.telestream.domain.Stream;
import com.savushkin.telestream.domain.telegram.SendMessageDTO;
import com.savushkin.telestream.domain.telegram.Update;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("/restart")
@AllArgsConstructor
public class RestartCommandExecutor implements CommandExecutor {
    private final StreamRepository streamRepository;
    private final ResponseSenderService responseSenderService;

    @Override
    public void executeCommand(Update update) {
        executeCommandTemplate(update, streamRepository, responseSenderService);
    }

    @Override
    public void updateStream(Stream stream) {
        stream.setYear(null);
        stream.setName(null);
        stream.setSeason(null);
        stream.setEpisode(null);
    }

    @Override
    public Optional<String> checkStreamForErrors(Stream stream) {
        return Optional.empty();
    }

    @Override
    public SendMessageDTO getSuccessMessage(long chatId, Stream stream) {
        return new SendMessageDTO(chatId, "All parameters have been reset");
    }

}
