package africa.semicolon.gemstube.User;

import africa.semicolon.gemstube.EmailSender.EmailRequest;
import africa.semicolon.gemstube.EmailSender.MailService;
import africa.semicolon.gemstube.EmailSender.Recipiant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private  final MailService mailService;
    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
       User savedUser =  userRepository.save(user);
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setRecipiants(List.of(new Recipiant(savedUser.getEmail(),"friend")));
        emailRequest.setHtmlContent("<p>Hi, welcome to gemstube.com, we are so glad to have you here</p>");
        emailRequest.setSubject("welcome to gemstube streaming service");
        mailService.sendMail(emailRequest);
        return new RegisterResponse(savedUser.getId());
    }
}
