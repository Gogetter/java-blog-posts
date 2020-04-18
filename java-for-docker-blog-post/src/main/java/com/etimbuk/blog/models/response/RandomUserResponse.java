package com.etimbuk.blog.models.response;

import com.etimbuk.blog.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomUserResponse {
    private List<User> results;
}
