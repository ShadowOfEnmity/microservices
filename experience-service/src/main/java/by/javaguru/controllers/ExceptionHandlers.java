package by.javaguru.controllers;

import by.javaguru.exceptions.ErrorResponse;
import by.javaguru.exceptions.ExperienceNotFound;
import by.javaguru.exceptions.IndustryException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
public class ExceptionHandlers {

    private static final String EUROPE_MINSK = "Europe/Minsk";

    @ExceptionHandler(ExperienceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleAboutNotFoundException(ExperienceNotFound exception) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                ZonedDateTime.now().withZoneSameInstant(ZoneId.of(EUROPE_MINSK)));
    }

    @ExceptionHandler(IndustryException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleAboutNotFoundException(IndustryException exception) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                ZonedDateTime.now().withZoneSameInstant(ZoneId.of(EUROPE_MINSK)));
    }
}