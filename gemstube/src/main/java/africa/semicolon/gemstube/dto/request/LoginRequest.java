package africa.semicolon.gemstube.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

@Getter
@Setter
@NoArgsConstructor
public class LoginRequest {
    private String name;
    private String password;
    private String email;
}
