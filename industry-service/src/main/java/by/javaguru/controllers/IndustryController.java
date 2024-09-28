package by.javaguru.controllers;

import by.javaguru.dto.IndustryDto;
import by.javaguru.dto.IndustryResponseDto;
import by.javaguru.service.IndustryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/industry")
@RequiredArgsConstructor
@RestController
public class IndustryController {

    @Autowired
    private IndustryServiceImpl industryService;

    @PostMapping
    public ResponseEntity<IndustryResponseDto> save(@RequestBody IndustryDto industry){
        var response = industryService.save(industry);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<IndustryResponseDto> getIndustryById(@PathVariable("id") Long id) {
        var response = industryService.findIndustryById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
