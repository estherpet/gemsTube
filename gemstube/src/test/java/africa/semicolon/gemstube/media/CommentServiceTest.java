package africa.semicolon.gemstube.media;

import africa.semicolon.gemstube.dto.request.AddCommentRequest;
import africa.semicolon.gemstube.dto.request.UpdateCommentRequest;
import africa.semicolon.gemstube.dto.response.ApiResponse;
import africa.semicolon.gemstube.exception.GemstubeException;
import africa.semicolon.gemstube.service.CommentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CommentServiceTest {
    @Autowired
    private CommentService commentService;

    @Test
    @Sql(value = "/insert.sql")
    public void addCommentTest() throws GemstubeException {
        AddCommentRequest request = new AddCommentRequest();
        request.setCommenter(1L);
        request.setComment("i like u");
     var response =  commentService.addComment(102L,request);
     assertThat(response).isNotNull();
     assertThat(response).isInstanceOf(ApiResponse.class);
    }
    @Test
    @Sql(value = "/insert.sql")
    public void updateCommentTest() throws GemstubeException {
        UpdateCommentRequest request = new UpdateCommentRequest();
        request.setText("i now like your picture");
      ApiResponse<?> response = commentService.updateComment(200L,102L,request);
      assertThat(response).isNotNull();
      assertThat(response.getMessage()).isNotNull();
    }

}
