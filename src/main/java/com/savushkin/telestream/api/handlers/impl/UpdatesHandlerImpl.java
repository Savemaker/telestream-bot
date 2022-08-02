package com.savushkin.telestream.api.handlers.impl;

import com.savushkin.telestream.api.handlers.UpdatesHandler;
import com.savushkin.telestream.app.sender.ResponseSenderService;
import com.savushkin.telestream.app.TelestreamBotService;
import com.savushkin.telestream.domain.telegram.Update;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class UpdatesHandlerImpl implements UpdatesHandler {
    private final TelestreamBotService telestreamBotService;

    @Override
    public Mono<ServerResponse> handleUpdates(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Update.class)
                .doOnNext(telestreamBotService::processUpdate)
                .flatMap(update -> ServerResponse.ok().build());
    }
}
