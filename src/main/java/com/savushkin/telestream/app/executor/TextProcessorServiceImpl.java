package com.savushkin.telestream.app.executor;

import com.savushkin.telestream.app.repository.StreamRepository;
import com.savushkin.telestream.app.sender.ResponseSenderService;
import com.savushkin.telestream.domain.Stream;
import com.savushkin.telestream.domain.telegram.SendMessageDTO;
import com.savushkin.telestream.domain.telegram.Update;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TextProcessorServiceImpl implements TextProcessorService {
    private final StreamRepository streamRepository;
    private final ResponseSenderService responseSenderService;

    @Override
    public void processText(Update update) {
        if (update == null || update.getMessage() == null) {
            return;
        }
        long chatId = update.getMessage().getChat().getId();
        Stream stream = streamRepository.getStream(chatId);
        if (stream.getSetNext() == null) {
            return;
        }
        switch (stream.getSetNext()) {
            case NAME:
                stream.setName(update.getMessage().getText());
                stream.setEpisode("1");
                stream.setSeason("1");
                responseSenderService.respondToCustomer(new SendMessageDTO(chatId, "Name set successfully"));
                break;
            case YEAR:
                stream.setYear(update.getMessage().getText());
                responseSenderService.respondToCustomer(new SendMessageDTO(chatId, "Year set successfully"));
                break;
            case SEASON:
                stream.setSeason(update.getMessage().getText());
                responseSenderService.respondToCustomer(new SendMessageDTO(chatId, "Season set successfully"));
                break;
            case EPISODE:
                stream.setEpisode(update.getMessage().getText());
                responseSenderService.respondToCustomer(new SendMessageDTO(chatId, "Episode set successfully"));
                break;
        }
    }
}
