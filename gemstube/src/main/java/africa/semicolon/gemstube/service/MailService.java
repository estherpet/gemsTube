package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.dto.request.EmailRequest;
import africa.semicolon.gemstube.dto.response.EmailResponse;

public interface MailService {
  EmailResponse sendMail(EmailRequest emailRequest);
}
