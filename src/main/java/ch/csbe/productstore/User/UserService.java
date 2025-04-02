package ch.csbe.productstore.User;

import ch.csbe.productstore.User.dto.LoginRequestDto;
import ch.csbe.productstore.User.dto.UserCreateDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUserWithCredentials(LoginRequestDto loginRequestDto);
    User findUserByEmail(String email);
    String login(LoginRequestDto loginRequestDto);
    HttpStatus register(UserCreateDto userCreateDto);
    HttpStatus changeRoleOfUser(String role, Long userId);
}
