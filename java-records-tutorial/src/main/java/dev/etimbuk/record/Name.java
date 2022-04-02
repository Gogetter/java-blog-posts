package dev.etimbuk.record;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Name(
        @JsonProperty("title") String title,
        @JsonProperty("first") String first,
        @JsonProperty("last") String last) {
}
