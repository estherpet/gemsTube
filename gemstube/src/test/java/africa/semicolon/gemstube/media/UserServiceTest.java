package africa.semicolon.gemstube.media;

import africa.semicolon.gemstube.data.model.User;
import africa.semicolon.gemstube.dto.request.RegisterRequest;
import africa.semicolon.gemstube.dto.response.RegisterResponse;
import africa.semicolon.gemstube.exception.GemstubeException;
import africa.semicolon.gemstube.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    private RegisterRequest request;
    private RegisterResponse response;
    @BeforeEach
    public void setUp(){
         request = new RegisterRequest();
        request.setEmail("disis80526@dixiser.com");
        request.setPassword("password");

    }
    @Test
    public  void registerTest(){
        RegisterResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());
    }
    @Test
    public void getUserByIdTest() throws GemstubeException {
        User user  = userService.getUserById(response.getId());
        assertThat(user).isNotNull();
    }
}


