package dev.etimbuk.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.etimbuk.record.Person;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PersonHttpUtil {
    private PersonHttpUtil() {}

    public static Map<String, Object> fetchPerson() {
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create("https://randomuser.me/api/?results=1"))
                .build();

        Map<String, Object> response = new HashMap<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        httpClient.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(result -> {
                    try {
                        response.putAll(new ObjectMapper().readValue(result, Map.class));
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                })
                .join();
        return (response.isEmpty()) ? Map.of() : ((List<Map<String, Object>>) response.get("results")).get(0);
    }

    public static void main(String[] args) {
        Map<String, Object> person = PersonHttpUtil.fetchPerson();
        Person.from(person);
    }
}
