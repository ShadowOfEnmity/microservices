package by.javaguru.dto;

import lombok.Builder;

import java.io.Serializable;

@Builder(setterPrefix = "with")
public record IndustryResponseDto(Long id, String name) implements Serializable {
}
