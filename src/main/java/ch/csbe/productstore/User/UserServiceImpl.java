package ch.csbe.productstore.User;


import ch.csbe.productstore.Product.Product;
import ch.csbe.productstore.Product.ProductNotFoundException;
import ch.csbe.productstore.User.dto.LoginRequestDto;
import ch.csbe.productstore.User.dto.UserCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService  {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TokenService tokenService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) {
        User response = this.userRepository.getUserByEmail(email).orElseThrow(() -> new UserNotFoundException("User with the email " + email + " could not be found!"));
        return response;
    }

    public User getUserWithCredentials(LoginRequestDto loginRequestDto) {
        User user = userMapper.fromLoginRequestDto(loginRequestDto);
        return this.userRepository.getUserByCredentials(user.getEmail(), user.getPassword()).orElseThrow(() -> new UserNotFoundException("Email or password wrong!"));
    }

    public String login(LoginRequestDto loginRequestDto) {
        User user = userRepository.getUserByEmail(loginRequestDto.getEmail()).orElseThrow(() -> new UserNotFoundException("Email or password wrong!"));
        String hashedPassword = user.getPassword();
        boolean isPasswordMatch = passwordEncoder.matches(loginRequestDto.getPassword(), hashedPassword);
        if (isPasswordMatch) {
            return tokenService.generateToken(user);
        }
        throw new UserNotFoundException("Email or password wrong!");
    }

    public HttpStatus register(UserCreateDto userCreateDto) {
        User userWithHash = new User();
        userWithHash.setEmail(userCreateDto.getEmail());
        userWithHash.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        userWithHash.setUsername(userCreateDto.getUsername());
        this.userRepository.save(userWithHash);
        return HttpStatus.CREATED;
    }

    public HttpStatus changeRoleOfUser(String role, Long userId) {
        if(userRepository.existsById(userId)) {
            User user = userRepository.getUserById(userId).orElseThrow(() -> new UserNotFoundException("User with the id " + userId + " could not be found!"));
            user.setRole(role);
            this.userRepository.save(user);
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }

}
