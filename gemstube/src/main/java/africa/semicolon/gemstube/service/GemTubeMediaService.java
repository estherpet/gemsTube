package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.data.model.Media;
import africa.semicolon.gemstube.data.model.User;
import africa.semicolon.gemstube.data.repository.MediaRepository;
import africa.semicolon.gemstube.dto.request.UploadMediaRequest;
import africa.semicolon.gemstube.dto.response.UploadMediaResponse;
import africa.semicolon.gemstube.exception.GemstubeException;
import africa.semicolon.gemstube.exception.MediaUploadException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class GemTubeMediaService implements MediaService{
private final CloudService cloudService;
private final MediaRepository mediaRepository;
private final UserService userService;
private final ModelMapper modelMapper;
    @Override
    public UploadMediaResponse upload(UploadMediaRequest request) throws GemstubeException {
        User user = userService.getUserById(request.getCreatorId());
      String url = cloudService.upload(request.getMultipartFile());


      Media media = modelMapper.map(request,Media.class);
      media.setUrl(url);
      media.setUploader(user);

    Media savedMedia =   mediaRepository.save(media);
        return buildUploadMediaResponse(savedMedia);
    }
    private static UploadMediaResponse buildUploadMediaResponse(Media media){
        UploadMediaResponse response = new UploadMediaResponse();
        response.setMessage("media upload successfully");
        response.setMediaId(media.getId());
        return response;

    }
}
