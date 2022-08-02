package com.savushkin.telestream.api.config;

import com.savushkin.telestream.api.handlers.UpdatesHandler;
import com.savushkin.telestream.api.handlers.WebPlayerHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class UpdatesRouter {

    @Bean
    RouterFunction<ServerResponse> routes(UpdatesHandler updatesHandler, WebPlayerHandler webPlayerHandler) {
        return route()
                .POST("/updates", accept(MediaType.APPLICATION_JSON), updatesHandler::handleUpdates)
                .GET("/player/{stream}/{chatId}", accept(MediaType.APPLICATION_JSON), webPlayerHandler::handleUpdates)
                .build();
    }
}
