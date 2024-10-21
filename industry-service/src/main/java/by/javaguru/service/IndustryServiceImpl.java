package by.javaguru.service;

import by.javaguru.dto.IndustryDto;
import by.javaguru.dto.IndustryResponseDto;
import by.javaguru.exceptions.IndustryNotFound;
import by.javaguru.persistence.repository.IndustryRepository;
import by.javaguru.util.mapper.IndustryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Slf4j
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    IndustryRepository industryRepository;

    @Autowired
    IndustryMapper industryMapper;

    @Transactional
    @Override
    public IndustryResponseDto save(IndustryDto industry) {
        log.debug("Industry {} saving in progress", industry);
        return industryMapper.fromEntityToDto(industryRepository.save(industryMapper.fromDtoToEntity(industry)));
    }

    @Transactional(readOnly = true)
    @Override
    public IndustryResponseDto findIndustryById(long id) {
        log.debug("Industry is searched by #{}", id);
        return industryRepository.getIndustryById(id).map(industryMapper::fromEntityToDto).orElseThrow(() -> new IndustryNotFound("Industry not found"));
    }
}
