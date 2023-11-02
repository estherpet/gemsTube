package africa.semicolon.gemstube.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AddCommentRequest {
    private String comment;
    private Long commenter;
}
