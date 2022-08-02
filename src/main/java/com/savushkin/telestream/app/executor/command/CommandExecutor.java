package com.savushkin.telestream.app.executor.command;

import com.savushkin.telestream.app.repository.StreamRepository;
import com.savushkin.telestream.app.sender.ResponseSenderService;
import com.savushkin.telestream.domain.Stream;
import com.savushkin.telestream.domain.telegram.SendMessageDTO;
import com.savushkin.telestream.domain.telegram.Update;

import java.util.Optional;

public interface CommandExecutor {
    void executeCommand(Update update);

    Optional<String> checkStreamForErrors(Stream stream);

    SendMessageDTO getSuccessMessage(long chatId, Stream stream);

    default void executeCommandTemplate(Update update, StreamRepository streamRepository, ResponseSenderService responseSenderService) {
        long chatId = update.getMessage().getChat().getId();
        Stream stream = findStream(chatId, streamRepository);
        updateStream(stream);
        Optional<String> optionalError = checkStreamForErrors(stream);
        if (optionalError.isPresent()) {
            respondOnError(chatId, optionalError.get(), responseSenderService);
        } else {
            respondOnSuccess(chatId, stream, responseSenderService);
        }
    }

    default void updateStream(Stream stream) {

    }

    default Stream findStream(long chatId, StreamRepository streamRepository) {
        return streamRepository.getStream(chatId);
    }

    default void respondOnError(long chatId, String error, ResponseSenderService responseSenderService) {
        responseSenderService.respondToCustomer(new SendMessageDTO(chatId, error));
    }

    default void respondOnSuccess(long chatId, Stream stream, ResponseSenderService responseSenderService) {
        responseSenderService.respondToCustomer(getSuccessMessage(chatId, stream));
    }
}
