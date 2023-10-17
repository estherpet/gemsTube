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

import static africa.semicolon.gemstube.data.model.Type.IMAGE;
import static africa.semicolon.gemstube.data.model.Type.VIDEO;
import static africa.semicolon.gemstube.media.MediaServiceTest.uploadFileTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CloudServiceTest {
    @Autowired
    private CloudService cloudService;
    public static final String IMAGE_LOCATION = "C:\\Users\\Semicolon\\Downloads\\gemstube\\gemstube\\src\\main\\resources\\asset\\images (1).jfif";
    public static final String VIDEO_LOCATION ="C:\\Users\\Semicolon\\Downloads\\gemstube\\gemstube\\src\\main\\resources\\asset\\Thanos _You could not live with your own failure_ (Avengers End Game Trailer).mp4";
    public static  final String AUDIO_LOCATION ="";
    @Test
    public void testUploadImage() throws MediaUploadException{
        String response = cloudService.upload(uploadFileTest(IMAGE_LOCATION));
        assertNotNull(response);
    }
    @Test
    public void testUploadVideo() throws MediaUploadException{
        String response = cloudService.upload(uploadFileTest(VIDEO_LOCATION));
        assertNotNull(response);
    }

}
