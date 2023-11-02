package africa.semicolon.gemstube.Controller;

import africa.semicolon.gemstube.dto.request.RegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
   @Autowired
   private MockMvc mockMvc;
    @Test
    public void registerTest(){
        ObjectMapper mapper = new ObjectMapper();
        RegisterRequest request = new RegisterRequest();
        request.setEmail("bevew27735@qianhost.com");
        request.setPassword("password");
      try {
          byte[] json = mapper.writeValueAsBytes(request);
          mockMvc.perform(post("/api/v1/user")
                  .content(json)
                          .contentType(MediaType.APPLICATION_JSON))
                  .andExpect(status().is2xxSuccessful())
                  .andDo(print());
      }catch (Exception exception){
          exception.printStackTrace();
      }
    }
    @Test
    @Sql(value = "/insert.sql")
    public void getUserByIdTest(){
        registerTest();
        try {
            mockMvc.perform(get("/api/v1/user/1"))
                    .andExpect(status().is2xxSuccessful())
                    .andDo(print());
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
