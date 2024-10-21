package by.javaguru.dto;

import lombok.Builder;
import lombok.ToString;

import java.io.Serializable;

@Builder(setterPrefix = "with")
public record IndustryDto(String name) implements Serializable {
}
