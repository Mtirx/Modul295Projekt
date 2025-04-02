package ch.csbe.productstore.User;

import ch.csbe.productstore.User.dto.LoginRequestDto;
import ch.csbe.productstore.User.dto.UserCreateDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-02T13:29:52+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl extends UserMapper {

    @Override
    public User fromLoginRequestDto(LoginRequestDto loginRequestDto) {
        if ( loginRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setPassword( loginRequestDto.getPassword() );
        user.setEmail( loginRequestDto.getEmail() );

        return user;
    }

    @Override
    public User fromUserCreateDto(UserCreateDto userCreateDto) {
        if ( userCreateDto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( userCreateDto.getUsername() );
        user.setPassword( userCreateDto.getPassword() );
        user.setEmail( userCreateDto.getEmail() );

        return user;
    }
}
