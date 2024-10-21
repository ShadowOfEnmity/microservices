package by.javaguru.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder(setterPrefix = "with")
public record IndustryResponseDto(long id, String name) implements Serializable {
}
