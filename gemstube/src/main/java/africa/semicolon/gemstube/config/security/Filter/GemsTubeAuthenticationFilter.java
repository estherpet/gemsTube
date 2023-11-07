package africa.semicolon.gemstube.config.security.Filter;

import africa.semicolon.gemstube.dto.request.LoginRequest;
import africa.semicolon.gemstube.dto.response.LoginResponse;
import africa.semicolon.gemstube.exception.UserAuthenticationFailedException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@AllArgsConstructor
public class GemsTubeAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
    private final AuthenticationManager authenticationManager;
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper mapper = new ObjectMapper();
        try{
            InputStream inputStream = request.getInputStream();
            LoginRequest loginRequest = mapper.readValue(inputStream,LoginRequest.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword());
            Authentication authenticationResult = authenticationManager.authenticate(authentication);
            if (authenticationResult.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authenticationResult);
                return authenticationResult;
            }
        }catch (IOException exception){
            throw new RuntimeException(exception);
        }

        throw new UserAuthenticationFailedException("authentication failed");
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        JWT.create()
                .withIssuedAt(Instant.now())
                .withExpiresAt(Instant.now().plus(86400L, ChronoUnit.SECONDS))
                .sign(Algorithm.HMAC256("secret"));

        LoginResponse loginResponse = new LoginResponse(token);
        response.setContentType(APPLICATION_JSON_VALUE);

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
    }
}