package africa.semicolon.gemstube.controller;

import africa.semicolon.gemstube.dto.request.RegisterRequest;
import africa.semicolon.gemstube.dto.response.RegisterResponse;
import africa.semicolon.gemstube.exception.GemstubeException;
import africa.semicolon.gemstube.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<RegisterResponse> register (@RequestBody RegisterRequest request){
        RegisterResponse response = userService.register(request);
        return ResponseEntity.status(CREATED).body(response);
    }
@GetMapping("{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
    try {
      var response =  userService.getUserById(id);
      return ResponseEntity.ok(response);
    } catch (GemstubeException exception) {
        return ResponseEntity.badRequest().body(exception);
    }

}

}
