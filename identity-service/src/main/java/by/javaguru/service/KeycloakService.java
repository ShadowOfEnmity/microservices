package by.javaguru.service;

import reactor.core.publisher.Mono;

import java.util.Map;

public interface KeycloakService {
    Mono<Map<String, Object>> getToken(String login, String password);

    Mono<Boolean> validateToken(String token);
}
