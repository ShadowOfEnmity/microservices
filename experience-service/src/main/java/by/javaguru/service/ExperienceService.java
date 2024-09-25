package by.javaguru.service;

import by.javaguru.dto.ExperienceDto;
import by.javaguru.dto.ExperienceResponseDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ExperienceService {
    ExperienceResponseDto save(ExperienceDto experience);

    ExperienceResponseDto findExperienceById(long id);
}
