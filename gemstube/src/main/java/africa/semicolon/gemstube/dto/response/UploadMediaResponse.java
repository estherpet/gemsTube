package africa.semicolon.gemstube.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadMediaResponse {
    private String message;
    private Long mediaId;
}
