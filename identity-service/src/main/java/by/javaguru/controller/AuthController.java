package by.javaguru.controller;

import by.javaguru.dto.AuthRequest;
import by.javaguru.service.KeycloakService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final KeycloakService keycloakService;

    @PostMapping(value = "/token",  consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Map<String, Object>>> getToken(@RequestBody AuthRequest authRequest) {
        var token = keycloakService.getToken(authRequest.getLogin(), authRequest.getPassword());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @GetMapping("/validate")
    public ResponseEntity<Mono<Boolean>> validationToken(@RequestParam("token") String token) {
        var mapMono = keycloakService.validateToken(token);
        return new ResponseEntity<>(mapMono, HttpStatus.OK);
    }

}
