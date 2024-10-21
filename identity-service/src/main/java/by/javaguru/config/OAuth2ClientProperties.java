package by.javaguru.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.client")
public class OAuth2ClientProperties {
    private Map<String, ClientRegistrationProperties> registration;
    @Autowired
    private OAuth2ProviderProperties keycloakProviderProperties;

    public Map<String, ClientRegistrationProperties> getRegistration() {
        return registration;
    }

    public void setRegistration(Map<String, ClientRegistrationProperties> registration) {
        this.registration = registration;
    }

    @Data
    public static class ClientRegistrationProperties {
        private String clientId;
        private String clientSecret;
        private String scope;
        private String authorizationGrantType;
        private String issuerUri;

    }

    @PostConstruct
    public void init() {
        if (registration != null && registration.containsKey("keycloak")) {
            ClientRegistrationProperties keycloakClient = registration.get("keycloak");
            keycloakClient.setIssuerUri(keycloakProviderProperties.getIssuerUri());
        }
    }
}
