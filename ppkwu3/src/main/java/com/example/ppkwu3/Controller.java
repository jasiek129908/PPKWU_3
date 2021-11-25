package com.example.ppkwu3;

import org.json.CDL;
import org.json.JSONArray;
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

        return createXmlResponse(responseApi);
    }

    @GetMapping(value = "/csv", produces = {"text/plain"})
    public String getResponseAsCsv(@RequestParam("text") String textToProcess) {
        ResponseApi responseApi = callExternalStringUtilityApi("http://localhost:8080", textToProcess);

        return createCsvResponse(responseApi);
    }

    @GetMapping(value ="/txt", produces = {"text/plain"})
    public String getResponseAsText(@RequestParam("text") String textToProcess){
        ResponseApi responseApi = callExternalStringUtilityApi("http://localhost:8080", textToProcess);
        return String.format("Text: %s\nupperCase: %d\nlowerCase: %d\ndigits: %d\nwhiteCharacters: %d\nspecialCharacters: %d",
                responseApi.getTextToProcess(),responseApi.getUpperCaseCounter(),responseApi.getLowerCaseCounter(),responseApi.getDigitCounter(),
                responseApi.getWhiteSpaceCounter(),responseApi.getSpecialCharacterCounter());
    }

    private String createCsvResponse(ResponseApi responseApi) {
        JSONArray jsonArray = new JSONArray();
        jsonArray.put(new JSONObject(responseApi));
        String res = CDL.toString(jsonArray);
        return res;
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
