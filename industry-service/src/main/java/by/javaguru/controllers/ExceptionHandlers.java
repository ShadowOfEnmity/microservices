package by.javaguru.controllers;

import by.javaguru.exceptions.ErrorResponse;
import by.javaguru.exceptions.IndustryNotFound;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlers {

    private static final String EUROPE_MINSK = "Europe/Minsk";

    @ExceptionHandler(IndustryNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleAboutNotFoundException(IndustryNotFound exception) {
        log.debug("Industry not found");
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                ZonedDateTime.now().withZoneSameInstant(ZoneId.of(EUROPE_MINSK)));
    }

}