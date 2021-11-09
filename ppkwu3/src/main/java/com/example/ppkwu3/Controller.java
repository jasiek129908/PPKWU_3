package com.example.ppkwu3;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<ResponseApi> getResponseAsJson(@RequestParam("text") String textToProcess) {
        ResponseApi responseApi = callExternalStringUtilityApi("http://localhost:8080", textToProcess);

        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }


    private ResponseApi callExternalStringUtilityApi(String path, String textToProcess) {
        Mono<ResponseApi> text = WebClient.create(path)
                .get()
                .uri(uriBuilder -> uriBuilder.path("/string")
                        .queryParam("text", textToProcess)
                        .build())
                .retrieve()
                .bodyToMono(ResponseApi.class);
        return text.block();
    }
}
