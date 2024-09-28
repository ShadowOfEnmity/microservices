package by.javaguru.util.mapper;


import by.javaguru.dto.IndustryDto;
import by.javaguru.dto.IndustryResponseDto;
import by.javaguru.persistence.model.Industry;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true))
public interface IndustryMapper {

    IndustryResponseDto fromEntityToDto(Industry industry);

    Industry fromDtoToEntity(IndustryDto industry);
}
