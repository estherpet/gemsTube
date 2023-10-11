package africa.semicolon.gemstube.media;

import africa.semicolon.gemstube.dto.request.UploadMediaRequest;
import africa.semicolon.gemstube.dto.response.UploadMediaResponse;
import africa.semicolon.gemstube.service.MediaService;
import com.cloudinary.api.ApiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class MediaServiceTest {
    @Autowired
    private MediaService mediaService;
    @Test
    public  void uploadMediaTest(){
        UploadMediaRequest request = new UploadMediaRequest();
        UploadMediaResponse response = mediaService.upload(request);
        assertThat(response).isNotNull();
    }
}
