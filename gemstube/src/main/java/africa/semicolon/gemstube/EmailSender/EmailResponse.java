package africa.semicolon.gemstube.EmailSender;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmailResponse {
    private String messageId;
    private Integer code;
}
