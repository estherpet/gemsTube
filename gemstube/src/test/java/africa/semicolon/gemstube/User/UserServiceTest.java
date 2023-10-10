package africa.semicolon.gemstube.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public  void registerTest(){
        RegisterRequest request = new RegisterRequest();
        request.setEmail("disis80526@dixiser.com");
        request.setPassword("password");

        RegisterResponse response = userService.register(request);
        assertNotNull(response);
        assertNotNull(response.getId());
    }
}


