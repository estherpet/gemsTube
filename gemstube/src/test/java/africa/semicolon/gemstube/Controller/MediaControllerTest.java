package africa.semicolon.gemstube.Controller;

import africa.semicolon.gemstube.dto.request.UploadMediaRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockPart;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import static africa.semicolon.gemstube.media.CloudServiceTest.IMAGE_LOCATION;
import static africa.semicolon.gemstube.media.MediaServiceTest.uploadFileTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

@SpringBootTest
@AutoConfigureMockMvc
public class MediaControllerTest {
    @Autowired
    private MockMvc mockMvc;

@Test
    public void uploadMediaTest(){
    UploadMediaRequest request = new UploadMediaRequest();
    MultipartFile file = uploadFileTest(IMAGE_LOCATION);
    request.setTitle("my image");
    request.setDescription("my first image upload");
    request.setCreatorId(100L);
    request.setMultipartFile(file);

//    mockMvc.perform(multipart("/api/v1/media").
//            part(new MockPart("media",file.getBytes())))

    }

}
