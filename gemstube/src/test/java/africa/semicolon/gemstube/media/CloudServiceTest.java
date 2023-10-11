package africa.semicolon.gemstube.media;

import africa.semicolon.gemstube.exception.MediaUploadException;
import africa.semicolon.gemstube.service.CloudService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CloudServiceTest {
    @Autowired
    private CloudService cloudService;
    @Test
    public void uploadFileTest(){
        Path path = Paths.get("C:\\Users\\Semicolon\\Downloads\\gemstube\\gemstube\\src\\main\\resources\\asset\\images (1).jfif");
       try ( var inputStream = Files.newInputStream(path)) {
           MultipartFile file = new MockMultipartFile("test-image",inputStream);
           String response = cloudService.upload(file);
           assertNotNull(response);
       }catch (IOException | MediaUploadException exception){
           exception.printStackTrace();
           log.error("ERROR :: {}",exception.getMessage());
       }
    }
}
