package by.javaguru.service.client;

import by.javaguru.dto.IndustryDto;
import by.javaguru.dto.IndustryResponseDto;
import by.javaguru.service.client.conf.FeignClientConfiguration;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "INDUSTRY-SERVICE", configuration = FeignClientConfiguration.class)
public interface IndustryServiceFeignClient {

    @CircuitBreaker(name = "industry-service", fallbackMethod = "getIndustryByIdFallback")
    @Retry(name = "industry-service", fallbackMethod = "getIndustryByIdFallback")
    @GetMapping("/api/v1/industry/{id}")
    IndustryResponseDto getIndustryById(@PathVariable("id") Long id);

    @PostMapping("/api/v1/industry")
    IndustryResponseDto save(@RequestBody IndustryDto industry);

    default IndustryResponseDto getIndustryByIdFallback(Long id, Throwable exception) {
        System.out.println("Industry id: " + id);
        System.out.println("exception: " + exception.getMessage());
        return new IndustryResponseDto(0L, "stub");
    }
}
