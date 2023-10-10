package africa.semicolon.gemstube.EmailSender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sender {
    private  final String email ;
    private final   String name;

    public Sender(String email, String name) {
        this.email= email;
        this.name = name;
    }
}
