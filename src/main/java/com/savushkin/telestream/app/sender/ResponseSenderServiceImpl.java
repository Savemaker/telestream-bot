package com.savushkin.telestream.app.sender;

import com.savushkin.telestream.domain.telegram.Message;
import com.savushkin.telestream.domain.telegram.SendMessageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class ResponseSenderServiceImpl implements ResponseSenderService {
    @Value("${URL_SEND_MESSAGE}")
    private String url;

    @Override
    public void respondToCustomer(SendMessageDTO message) {
        WebClient.builder().baseUrl(url)
                .build()
                .post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(message))
                .retrieve()
                .bodyToMono(Message.class)
                .subscribe();
    }
}
