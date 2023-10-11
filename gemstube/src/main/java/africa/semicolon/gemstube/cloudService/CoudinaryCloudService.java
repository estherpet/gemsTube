package africa.semicolon.gemstube.cloudService;

import africa.semicolon.gemstube.exception.MediaUploadException;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
@Slf4j
@Service
public class CoudinaryCloudService implements CloudService{
    @Override
    public String upload(MultipartFile file) throws MediaUploadException {
        Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dfs5pmdxd",
                "api_key", "793474996388632",
                "api_secret", "t_FuztZCoiZea4nyk0OhFnGiQKQ",
                "secure","true"));
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
