package by.javaguru.service.client.conf;

import by.javaguru.exceptions.IndustryBadRequestException;
import by.javaguru.exceptions.IndustryResourceNotFound;
import feign.Response;
import feign.codec.ErrorDecoder;
import jakarta.ws.rs.InternalServerErrorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeignClientErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    private final static Logger LOGGER = LoggerFactory.getLogger(FeignClientErrorDecoder.class);

    @Override
    public Exception decode(String methodKey, Response response) {
        return switch (response.status()) {
            case 400 -> new IndustryBadRequestException("Bad request: " + response.body());
            case 404 -> new IndustryResourceNotFound("Resource not found: " + response.request().url());
            case 500 -> new InternalServerErrorException("Internal server error");
            default -> defaultErrorDecoder.decode(methodKey, response);
        };
    }
}
