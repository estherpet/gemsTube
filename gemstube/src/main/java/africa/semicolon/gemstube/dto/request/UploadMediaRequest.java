package africa.semicolon.gemstube.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UploadMediaRequest {
    private Long creatorId;
    private MultipartFile multipartFile;
    private String description;
    private String title;

}
