package by.javaguru.controllers;

import by.javaguru.dto.ExperienceDto;
import by.javaguru.dto.ExperienceResponseDto;
import by.javaguru.service.ExperienceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/experience")
//@RequiredArgsConstructor
@RestController
public class ExperienceController {

    @Autowired
    private ExperienceServiceImpl experienceService;

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceResponseDto> getExperienceById(@PathVariable("id") Long id) {
        var response = experienceService.findExperienceById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ExperienceResponseDto> add(@RequestBody ExperienceDto experience) {
        var response = experienceService.save(experience);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
