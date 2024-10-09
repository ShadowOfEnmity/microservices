package by.javaguru.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.security.oauth2.client.provider.keycloak")
@Data
public class OAuth2ProviderProperties {
    private String issuerUri;
}
