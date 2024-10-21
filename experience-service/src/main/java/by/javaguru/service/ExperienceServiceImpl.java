package by.javaguru.service;

import by.javaguru.dto.ExperienceDto;
import by.javaguru.dto.ExperienceResponseDto;
import by.javaguru.dto.IndustryDto;
import by.javaguru.dto.IndustryResponseDto;
import by.javaguru.exceptions.ExperienceNotFound;
import by.javaguru.persistence.model.Experience;
import by.javaguru.persistence.repository.ExperienceRepository;
import by.javaguru.service.client.IndustryServiceFeignClient;
import by.javaguru.util.mapper.ExperienceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExperienceServiceImpl implements ExperienceService {


    private final ExperienceMapper experienceMapper;

    private final ExperienceRepository experienceRepository;

    private final IndustryServiceFeignClient industryServiceClient;

    @Transactional
    @Override
    public ExperienceResponseDto save(ExperienceDto experience) {
        IndustryDto industryDto = IndustryDto.builder().withName(experience.industry()).build();
        IndustryResponseDto industryResponse = industryServiceClient.save(industryDto);
        log.debug("Industry {} is saved", industryDto);
        Experience savedExperience = experienceRepository.save(experienceMapper.toExperienceEntityByIndustryResponseDto(experience, industryResponse));
        ExperienceResponseDto experienceResponseDto = experienceMapper.toExperienceResponseDto(savedExperience, industryResponse);
        log.debug("Experience {} is saved", experienceResponseDto);
        return experienceResponseDto;
    }

    @Transactional(readOnly = true)
    @Override
    public ExperienceResponseDto findExperienceById(long id) {
        ExperienceResponseDto responseDto = experienceRepository.findExperienceById(id).map(experienceMapper::toExperienceResponseDto).orElseThrow(() -> new ExperienceNotFound("Experience not found"));
        log.debug("Experience {} is found", responseDto);
        return responseDto;
    }
}
