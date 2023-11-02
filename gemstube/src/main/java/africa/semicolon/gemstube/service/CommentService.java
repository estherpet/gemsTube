package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.dto.request.AddCommentRequest;
import africa.semicolon.gemstube.dto.request.UpdateCommentRequest;
import africa.semicolon.gemstube.dto.response.ApiResponse;
import africa.semicolon.gemstube.exception.GemstubeException;
import africa.semicolon.gemstube.exception.ResoureNotFoundException;


public interface CommentService {
 ApiResponse<?> addComment(Long id, AddCommentRequest request) throws GemstubeException;

 ApiResponse<?> updateComment(Long commentId, Long userId, UpdateCommentRequest request) throws GemstubeException;
}
