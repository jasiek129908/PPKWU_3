package com.example.ppkwu3;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class Controller {

    @GetMapping("/json")
    public ResponseEntity<ResponseApi> getResponseAsJson(@RequestParam("text") String textToProcess) {
        ResponseApi responseApi = callExternalStringUtilityApi("http://localhost:8080", textToProcess);

        return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }

    @GetMapping(value = "/xml", produces = {"application/xml", "text/xml"})
    public String getResponseAsXml(@RequestParam("text") String textToProcess) {
        ResponseApi responseApi = callExternalStringUtilityApi("http://localhost:8080", textToProcess);

        String xmlResponse = createXmlResponse(responseApi);
        return xmlResponse;
    }

    private String createXmlResponse(ResponseApi responseApi) {
        JSONObject jsonObject = new JSONObject(responseApi);
        StringBuilder res = new StringBuilder("<response>");
        res.append(XML.toString(jsonObject));
        res.append("</response>");
        return res.toString();
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
