package com.etimbuk.blog.components;

import com.etimbuk.blog.models.User;
import com.etimbuk.blog.models.response.RandomUserResponse;
import com.etimbuk.blog.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

import static java.net.URI.create;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class DataInitializer {
    @Value("${random-user.api}")
    private String randomUserApiUrl;

    private final RestTemplate restTemplate;
    private final UserRepository userRepository;

    @PostConstruct
    public void initializeData() {
        RandomUserResponse randomUserResponse =
                restTemplate.getForObject(create(randomUserApiUrl), RandomUserResponse.class);

        if (!randomUserResponse.getResults().isEmpty()) {
            userRepository.saveAll(randomUserResponse.getResults());
        }
    }
}
