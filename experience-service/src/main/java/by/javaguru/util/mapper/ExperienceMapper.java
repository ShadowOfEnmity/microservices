package by.javaguru.util.mapper;

import by.javaguru.dto.ExperienceDto;
import by.javaguru.dto.ExperienceResponseDto;
import by.javaguru.dto.IndustryResponseDto;
import by.javaguru.persistence.model.Experience;
import by.javaguru.service.client.IndustryServiceFeignClient;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        builder = @Builder(disableBuilder = true))
public abstract class ExperienceMapper {

//    @Autowired
//    protected IndustryServiceClient industryClient;
    @Autowired
    protected IndustryServiceFeignClient industryClient;

    @Mapping(target = "industry", expression = "java(getIndustryName(industryClient.getIndustryById(experience.getIndustry())))")
    public abstract ExperienceResponseDto toExperienceResponseDto(Experience experience);

    @Mapping(target = "industry", expression = "java(industry.name())")
    public abstract ExperienceResponseDto toExperienceResponseDto(Experience experience, IndustryResponseDto industry);

    @Mapping(target = "industry", ignore = true)
    public abstract Experience toExperienceEntity(ExperienceDto dto);

    @Mapping(target = "industry", expression = "java(industry.id())")
    @Mapping(target = "id", ignore = true)
    public abstract Experience toExperienceEntityByIndustryResponseDto(ExperienceDto experience, IndustryResponseDto industry);

    public String getIndustryName(IndustryResponseDto industry){
        return industry.name();
    }
}
