package by.javaguru.config;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.InMemoryReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

import java.util.Collections;

@RequiredArgsConstructor
@Configuration
public class OAuth2ClientConfig {
    private final OAuth2ClientProperties oAuth2ClientProperties;

    @Bean
    public ReactiveClientRegistrationRepository clientRegistrationRepository() {

        OAuth2ClientProperties.ClientRegistrationProperties keycloakProperties =
                oAuth2ClientProperties.getRegistration().get("keycloak");

        ClientRegistration keycloakClientRegistration = ClientRegistration.withRegistrationId("keycloak")
                .clientId(keycloakProperties.getClientId())
                .clientSecret(keycloakProperties.getClientSecret())
                .scope(keycloakProperties.getScope())
                .authorizationGrantType(new AuthorizationGrantType(keycloakProperties.getAuthorizationGrantType()))
                .tokenUri(Strings.concat(keycloakProperties.getIssuerUri(), "/protocol/openid-connect/token"))
                .build();

        return new InMemoryReactiveClientRegistrationRepository(Collections.singletonList(keycloakClientRegistration));
    }
}
