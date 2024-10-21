package by.javaguru.service;

import by.javaguru.dto.IndustryDto;
import by.javaguru.dto.IndustryResponseDto;
import org.springframework.stereotype.Service;

public interface IndustryService {
    IndustryResponseDto save(IndustryDto industry);

    IndustryResponseDto findIndustryById(long id);
}
