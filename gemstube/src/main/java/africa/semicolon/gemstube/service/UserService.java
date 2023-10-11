package africa.semicolon.gemstube.service;

import africa.semicolon.gemstube.dto.request.RegisterRequest;
import africa.semicolon.gemstube.dto.response.RegisterResponse;

public interface UserService {
    RegisterResponse register(RegisterRequest request);
}
