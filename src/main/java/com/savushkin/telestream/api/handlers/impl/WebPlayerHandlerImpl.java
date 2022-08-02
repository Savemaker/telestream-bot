package com.savushkin.telestream.api.handlers.impl;

import com.savushkin.telestream.api.handlers.WebPlayerHandler;
import com.savushkin.telestream.app.finder.StreamFinderService;
import com.savushkin.telestream.app.repository.StreamRepository;
import com.savushkin.telestream.domain.Stream;
import com.savushkin.telestream.domain.StreamType;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

@Component
@AllArgsConstructor
public class WebPlayerHandlerImpl implements WebPlayerHandler {
    private final StreamRepository streamRepository;
    private final StreamFinderService streamFinderService;

    @Override
    public Mono<ServerResponse> handleUpdates(ServerRequest serverRequest) {
        String chatId = serverRequest.pathVariable("chatId");
        String movieOrShow = serverRequest.pathVariable("stream");
        Stream stream = streamRepository.getStream(Long.parseLong(chatId));
        String streamUrl = movieOrShow.equals("movie") ? streamFinderService.getStreamUrl(stream, StreamType.MOVIE) : streamFinderService.getStreamUrl(stream, StreamType.SHOW);
        final Map<String, Object> model =
                Collections.singletonMap("url", streamUrl);
        return ServerResponse.ok().contentType(MediaType.TEXT_HTML).render("index", model);
    }
}
