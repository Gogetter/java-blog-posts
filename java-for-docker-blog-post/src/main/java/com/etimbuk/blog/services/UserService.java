package com.etimbuk.blog.services;

import com.etimbuk.blog.models.User;
import com.etimbuk.blog.repos.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.StringUtils.isEmpty;

@Service
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserByEmail(final String email) {
        if (!isEmpty(email)) {
            return Optional.of(userRepository.findByEmail(email));
        }

        return Optional.empty();
    }
}
