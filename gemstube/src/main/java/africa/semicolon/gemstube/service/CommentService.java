package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.dto.request.AddCommentRequest;
import africa.semicolon.gemstube.dto.response.ApiResponse;
import africa.semicolon.gemstube.exception.GemstubeException;


public interface CommentService {
 ApiResponse<?> addComment(Long id, AddCommentRequest request) throws GemstubeException;

}
