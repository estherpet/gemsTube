package africa.semicolon.gemstube.EmailSender;

public interface MailService {
  EmailResponse  sendMail(EmailRequest emailRequest);
}
