package dev.etimbuk.record;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Person(
        @JsonProperty("gender") String gender,
        @JsonProperty("name") Name fullName,
        @JsonProperty("email") String email) {

    public static Person from(Map<String, Object> personMap) {
        return new ObjectMapper().convertValue(personMap, Person.class);
    }
}
