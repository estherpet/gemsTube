package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.data.model.Comment;
import africa.semicolon.gemstube.data.model.Media;
import africa.semicolon.gemstube.data.repository.CommentRepository;
import africa.semicolon.gemstube.dto.request.AddCommentRequest;
import africa.semicolon.gemstube.dto.response.ApiResponse;
import africa.semicolon.gemstube.exception.GemstubeException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final MediaService mediaService;
    private final ModelMapper modelMapper;
    private final UserService userService;
    private final CommentRepository commentRepository;
    @Override
    public ApiResponse<?> addComment(Long id, AddCommentRequest request) throws GemstubeException {
        Media foundMedia = mediaService.getMediaById(id);
        Comment comment = modelMapper.map(request,Comment.class);
        comment.setMedia(foundMedia);
        comment.setCommenter(userService.getUserById(request.getCommenter()));
        commentRepository.save(comment);
        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("comment added successfully");
        return response;
    }
}
