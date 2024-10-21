package by.javaguru.persistence.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("by.javaguru.persistence.model")
@EnableJpaRepositories("by.javaguru.persistence.repository")
public class RepositoryConfig {
}
