package com.example.ppkwu3;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.function.Function;

@RestController
public class Controller {

    @GetMapping("/json")
    public String getResponseAsJson() {
        WebClient.create("localhost:8080")
                .method(HttpMethod.GET)
                .uri(uriBuilder -> uriBuilder.path("/string")
                        .queryParam("text", "has  */123AX")
                        .build())
//                .header("Accept", "application/json, text/plain, */*")
                .retrieve()
                .bodyToMono(Object.class);
        return "halo";
    }

}
