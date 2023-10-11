package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.exception.MediaUploadException;
import org.springframework.web.multipart.MultipartFile;

public interface CloudService {
    String upload(MultipartFile file) throws MediaUploadException;
}
