package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.exception.MediaUploadException;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
@Slf4j
@Service
@AllArgsConstructor
public class CoudinaryCloudService implements CloudService{
    private final Cloudinary cloudinary;
    @Override
    public String upload(MultipartFile file) throws MediaUploadException {
        try {
            Map<?,?> uploadResponse = cloudinary.uploader().upload(file.getBytes(),ObjectUtils.emptyMap());
            log.info("upload response ->{}",uploadResponse);
            String url = (String) uploadResponse.get("secure_url");
            return url;
        }catch (IOException exception){
            throw new MediaUploadException(exception.getMessage());
        }
    }
}
