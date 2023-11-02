package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.data.model.Comment;
import africa.semicolon.gemstube.data.model.Media;
import africa.semicolon.gemstube.data.repository.CommentRepository;
import africa.semicolon.gemstube.dto.request.AddCommentRequest;
import africa.semicolon.gemstube.dto.request.UpdateCommentRequest;
import africa.semicolon.gemstube.dto.response.ApiResponse;
import africa.semicolon.gemstube.exception.GemstubeException;
import africa.semicolon.gemstube.exception.ResoureNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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

    @Override
    public ApiResponse<?> updateComment(Long commentId, Long userId, UpdateCommentRequest request) throws GemstubeException {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(()->new ResoureNotFoundException(String.format("comment with id %d not found",commentId)));
        var posterId = comment.getCommenter().getId();
        if (!posterId .equals(userId) )throw new GemstubeException("only original commenter can comment");
        comment.setText(request.getText());
        commentRepository.save(comment);

        ApiResponse<?> response = new ApiResponse<>();
        response.setMessage("comment updated successfully");
        return response;

    }
}
