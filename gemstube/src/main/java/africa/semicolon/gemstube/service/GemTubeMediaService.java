package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.data.model.Media;
import africa.semicolon.gemstube.dto.request.UploadMediaRequest;
import africa.semicolon.gemstube.dto.response.UploadMediaResponse;
import africa.semicolon.gemstube.exception.MediaUploadException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GemTubeMediaService implements MediaService{
private final CloudService cloudService;
    @Override
    public UploadMediaResponse upload(UploadMediaRequest request) throws MediaUploadException {
      String response = cloudService.upload(request.getMultipartFile());
      Media media = new Media();
        return null;
    }
}
