package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.config.MailConfig;
import africa.semicolon.gemstube.dto.request.EmailRequest;
import africa.semicolon.gemstube.dto.response.EmailResponse;
import africa.semicolon.gemstube.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import java.util.List;

import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {
    private final MailConfig mailConfig;
    @Override
    public EmailResponse sendMail(EmailRequest emailRequest) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(APPLICATION_JSON);
        httpHeaders.setAccept(List.of(APPLICATION_JSON));
        httpHeaders.set("api-key",mailConfig.getMailApiKey());
        HttpEntity<EmailRequest> requestHttpEntity= new RequestEntity<>(emailRequest,httpHeaders,POST,URI.create(""));
        ResponseEntity<EmailResponse> response = restTemplate.postForEntity(mailConfig.getBrevoMailUrl(),requestHttpEntity,EmailResponse.class);
        var emailResponse = response.getBody();
        emailResponse.setCode(response.getStatusCode().value());
        return emailResponse;
    }
}
