package com.savushkin.telestream.api.handlers;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public interface WebPlayerHandler {
    Mono<ServerResponse> handleUpdates(ServerRequest serverRequest);
}
