package by.javaguru.service.client;

import by.javaguru.dto.IndustryDto;
import by.javaguru.dto.IndustryResponseDto;
import by.javaguru.exceptions.IndustryException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IndustryServiceClient {

    private RestTemplate template;
    private static final String INDUSTRY_URL_PATTERN = "http://INDUSTRY-SERVICE/industry";

    public IndustryResponseDto getIndustryById(Long id) {
        var url = UriComponentsBuilder.fromHttpUrl(INDUSTRY_URL_PATTERN)
                .pathSegment("{id}").build(String.valueOf(id)).toString();

        ResponseEntity<IndustryResponseDto> response = template.getForEntity(url, IndustryResponseDto.class);
        if (!(response.getStatusCode().is2xxSuccessful() && response.hasBody())) {
            throw new IndustryException("Industry not found");
        }
        return response.getBody();
    }

    public IndustryResponseDto save(IndustryDto industry) {
        RequestEntity<IndustryDto> request = RequestEntity
                .post(URI.create("INDUSTRY_URL_PATTERN"))
                .accept(MediaType.APPLICATION_JSON)
                .body(industry);
        ResponseEntity<IndustryResponseDto> response = template.exchange(request, IndustryResponseDto.class);

        if (!(response.getStatusCode().is2xxSuccessful() && response.hasBody())) {
            throw new IndustryException("Industry not saved");
        }
        return response.getBody();
    }

}

