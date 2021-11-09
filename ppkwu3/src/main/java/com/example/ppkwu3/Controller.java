package com.example.ppkwu3;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.function.Function;

@RestController
public class Controller {

    @GetMapping("/json")
    public String getResponseAsJson() {
        Mono<ResponseApi> text = WebClient.create("http://localhost:8080")
                .get()
                .uri(uriBuilder -> uriBuilder.path("/string")
                        .queryParam("text", "has  */321AX")
                        .build())
                .retrieve()
                .bodyToMono(ResponseApi.class);
        System.out.println(text.block());

        return "halo";
    }

}
