package africa.semicolon.gemstube.media;

import africa.semicolon.gemstube.dto.request.RegisterRequest;
import africa.semicolon.gemstube.dto.request.UploadMediaRequest;
import africa.semicolon.gemstube.dto.response.UploadMediaResponse;
import africa.semicolon.gemstube.exception.GemstubeException;
import africa.semicolon.gemstube.service.MediaService;
import africa.semicolon.gemstube.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static africa.semicolon.gemstube.media.CloudServiceTest.IMAGE_LOCATION;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MediaServiceTest {
    @Autowired
    private MediaService mediaService;
    @Autowired
    private UserService userService;


    @Test
    public void TestuploadMedia() throws GemstubeException {
        RegisterRequest request = new RegisterRequest();
        request.setEmail("esther@gmail.com");
        request.setPassword("password");
        var registerResponse = userService.register(request);
        UploadMediaRequest request1 = new UploadMediaRequest();
        request1.setCreatorId(registerResponse.getId());
        request1.setTitle("this is our test");
        request1.setMultipartFile(uploadFileTest(IMAGE_LOCATION));

        UploadMediaResponse response = mediaService.upload(request1);
        assertThat(response).isNotNull();
    }

    public static MultipartFile uploadFileTest(String fileLocation) {
        Path path = Paths.get(fileLocation);
        MultipartFile file;
        try (var inputStream = Files.newInputStream(path)) {
            file = new MockMultipartFile("test-image", inputStream);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }
        return file;
    }
}
