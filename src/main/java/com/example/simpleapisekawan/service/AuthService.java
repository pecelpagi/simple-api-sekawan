package com.example.simpleapisekawan.service;

import com.example.simpleapisekawan.entity.User;
import com.example.simpleapisekawan.model.LoginUserRequest;
import com.example.simpleapisekawan.model.TokenResponse;
import com.example.simpleapisekawan.repository.UserRepository;
import com.example.simpleapisekawan.security.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    public TokenResponse login(LoginUserRequest request) {
        validationService.validate(request);

        User user = userRepository.findFirstByUsername(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());
            userRepository.save(user);

            return TokenResponse.builder()
                    .token(user.getToken())
                    .expiredAt(user.getTokenExpiredAt())
                    .build();
        } else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or password wrong");
        }
    }

    private Long next30Days() {
        return System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30);
    }

    public void logout(User user) {
        user.setToken(null);
        user.setTokenExpiredAt(null);

        userRepository.save(user);
    }

}
