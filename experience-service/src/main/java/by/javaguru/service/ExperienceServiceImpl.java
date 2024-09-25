package by.javaguru.service;

import by.javaguru.dto.ExperienceDto;
import by.javaguru.dto.ExperienceResponseDto;
import by.javaguru.dto.IndustryDto;
import by.javaguru.dto.IndustryResponseDto;
import by.javaguru.exceptions.ExperienceNotFound;
import by.javaguru.persistence.model.Experience;
import by.javaguru.persistence.repository.ExperienceRepository;
import by.javaguru.service.client.IndustryServiceClient;
import by.javaguru.util.mapper.ExperienceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {

    private final ExperienceMapper experienceMapper;

    private final ExperienceRepository experienceRepository;

    private final IndustryServiceClient industryServiceClient;

    @Transactional
    @Override
    public ExperienceResponseDto save(ExperienceDto experience) {
        IndustryResponseDto industryResponse = industryServiceClient.save(IndustryDto.builder().withName(experience.industry()).build());
        Experience savedExperience = experienceRepository.save(experienceMapper.toExperienceEntityByIndustryResponseDto(experience, industryResponse));
        return experienceMapper.toExperienceResponseDto(savedExperience, industryResponse);
    }

    @Transactional(readOnly = true)
    @Override
    public ExperienceResponseDto findExperienceById(long id) {
        return experienceRepository.findExperienceById(id).map(experienceMapper::toExperienceResponseDto).orElseThrow(() -> new ExperienceNotFound("Experience not found"));
    }
}
