package africa.semicolon.gemstube.dto.request;

import africa.semicolon.gemstube.data.model.Recipiant;
import africa.semicolon.gemstube.data.model.Sender;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Setter
@Getter
@AllArgsConstructor
public class EmailRequest {
    private  final Sender sender;
    @JsonProperty("to")
    private List<Recipiant> recipiants;
    private String subject;
    private  String htmlContent;
    public EmailRequest(){
        this.sender= new Sender("gemstube@hotmail.africa","gemstube inc.");
    }
}
