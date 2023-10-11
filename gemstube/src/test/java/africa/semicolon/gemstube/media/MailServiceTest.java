package africa.semicolon.gemstube.media;
import africa.semicolon.gemstube.data.model.Recipiant;
import africa.semicolon.gemstube.dto.request.EmailRequest;
import africa.semicolon.gemstube.dto.response.EmailResponse;
import africa.semicolon.gemstube.service.MailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;
    @Test
    public void sendMailTest(){
        Recipiant recipiant = new Recipiant();
        recipiant.setEmail("disis80526@dixiser.com");
        recipiant.setName("pat");
        List<Recipiant> recipiants = List.of(recipiant);
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setRecipiants(recipiants);
        emailRequest.setHtmlContent("<p>we are testing our app</p>");
        emailRequest.setSubject("testing 123...");

       EmailResponse response=  mailService.sendMail(emailRequest);
       assertNotNull(response);
       assertNotNull(response.getMessageId());
       assertNotNull(response.getCode());
       assertNotNull(201, String.valueOf(response.getCode()));
    }
}
