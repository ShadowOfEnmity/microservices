package by.javaguru.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.YearMonth;
import java.util.List;

@Builder(setterPrefix = "with")
public record ExperienceResponseDto(
        Integer sequenceNumber,
        YearMonth periodFrom,
        YearMonth periodTo,
        Boolean presentTime,
        String industry,
        String company,
        String position,
        List<String> duties,
        String achievements,
        String link
) implements Serializable {
}
