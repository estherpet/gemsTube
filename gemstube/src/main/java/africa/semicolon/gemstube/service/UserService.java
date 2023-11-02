package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.data.model.User;
import africa.semicolon.gemstube.dto.request.RegisterRequest;
import africa.semicolon.gemstube.dto.response.RegisterResponse;
import africa.semicolon.gemstube.exception.GemstubeException;

public interface UserService {
    RegisterResponse register(RegisterRequest request);

    User getUserById(Long id) throws GemstubeException;

}
