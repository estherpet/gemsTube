package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.dto.request.EmailRequest;
import africa.semicolon.gemstube.dto.request.RegisterRequest;
import africa.semicolon.gemstube.dto.response.RegisterResponse;
import africa.semicolon.gemstube.data.model.User;
import africa.semicolon.gemstube.data.repository.UserRepository;
import africa.semicolon.gemstube.data.model.Recipiant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
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
