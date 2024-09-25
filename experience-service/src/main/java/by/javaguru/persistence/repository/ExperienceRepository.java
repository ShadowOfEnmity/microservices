package by.javaguru.persistence.repository;

import by.javaguru.persistence.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {

    Optional<Experience> findExperienceById(Long id);

}
