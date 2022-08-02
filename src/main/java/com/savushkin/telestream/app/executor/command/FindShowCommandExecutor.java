package com.savushkin.telestream.app.executor.command;

import com.savushkin.telestream.app.checker.StreamCheckerService;
import com.savushkin.telestream.app.executor.InlineKeyboardMarkupPreparerService;
import com.savushkin.telestream.app.repository.StreamRepository;
import com.savushkin.telestream.app.sender.ResponseSenderService;
import com.savushkin.telestream.domain.Stream;
import com.savushkin.telestream.domain.StreamType;
import com.savushkin.telestream.domain.telegram.InlineKeyboardMarkup;
import com.savushkin.telestream.domain.telegram.SendMessageDTO;
import com.savushkin.telestream.domain.telegram.SendMessageDTOWithOptional;
import com.savushkin.telestream.domain.telegram.Update;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("/find_show")
@AllArgsConstructor
public class FindShowCommandExecutor implements CommandExecutor {
    private final StreamRepository streamRepository;
    private final StreamCheckerService streamCheckerService;
    private final ResponseSenderService responseSenderService;

    @Override
    public void executeCommand(Update update) {
        executeCommandTemplate(update, streamRepository, responseSenderService);
    }

    @Override
    public Optional<String> checkStreamForErrors(Stream stream) {
        return streamCheckerService.checkStream(stream, StreamType.SHOW);
    }

    @Override
    public SendMessageDTO getSuccessMessage(long chatId, Stream stream) {
        String url = "https://telestream-bot.herokuapp.com/player/show/" + chatId;
        return new SendMessageDTO(chatId, url);
    }
}
