package by.javaguru.controllers;

import by.javaguru.dto.IndustryDto;
import by.javaguru.dto.IndustryResponseDto;
import by.javaguru.service.IndustryServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/industry")
@RequiredArgsConstructor
@RestController
public class IndustryController {

    @Autowired
    private IndustryServiceImpl industryService;

    @PostMapping
    public IndustryResponseDto save(@RequestBody IndustryDto industry) {
        return industryService.save(industry);
    }


    @GetMapping("/{id}")
    public IndustryResponseDto getIndustryById(@PathVariable("id") Long id) {
        return industryService.findIndustryById(id);
    }
}
