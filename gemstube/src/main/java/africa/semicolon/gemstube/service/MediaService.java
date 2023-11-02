package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.data.model.Media;
import africa.semicolon.gemstube.dto.request.UploadMediaRequest;
import africa.semicolon.gemstube.dto.response.UploadMediaResponse;
import africa.semicolon.gemstube.exception.GemstubeException;
import africa.semicolon.gemstube.exception.MediaUploadException;

public interface MediaService {

    UploadMediaResponse upload(UploadMediaRequest request) throws GemstubeException;

    Media getMediaById(Long id);
}
