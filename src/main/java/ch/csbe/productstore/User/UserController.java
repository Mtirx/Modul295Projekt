package ch.csbe.productstore.User;

import ch.csbe.productstore.Product.dto.ProductCreateDto;
import ch.csbe.productstore.Product.dto.ProductUpdateDto;
import ch.csbe.productstore.User.dto.LoginRequestDto;
import ch.csbe.productstore.User.dto.UserCreateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name="User Controller")
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("login")
    @Operation(summary="Log in a existing account", operationId = "login", description = """
            Login with the email and password""")
    public String login(@Valid @RequestBody LoginRequestDto loginRequestDto){
        return userService.login(loginRequestDto);
    }

    @PostMapping("register")
    @Operation(summary="Create an account", operationId = "register", description = """
            Creates an account with an email, password and username""")
    public ResponseEntity<Void> register(@Valid @RequestBody UserCreateDto userCreateDto){
        HttpStatus status = userService.register(userCreateDto);
        return new ResponseEntity<>(status);
    }

    @PutMapping("{id}/role")
    @Operation(summary="Change the role of an user", operationId = "changeRole", description = """
            An existing admin can change the role of an user to either user, or admin""")
    public ResponseEntity<Void> changeRole(@Valid @RequestBody String role, @Parameter(description = "The id of the user") @PathVariable long id) {
        HttpStatus status = userService.changeRoleOfUser(role, id);
        return new ResponseEntity<>(status);
    }


}
