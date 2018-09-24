package com.millennium.webextractor.router;

import com.millennium.webextractor.handler.ExtractingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class ExtractingRouter {
    @Bean
    public RouterFunction<ServerResponse> route(ExtractingHandler extractingHandler) {

        return RouterFunctions
                .route(RequestPredicates
                        .GET("/extract")
                        .and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), extractingHandler::extract);
    }
}
