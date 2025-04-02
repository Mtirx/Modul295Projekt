package ch.csbe.productstore.User;

import ch.csbe.productstore.Product.Product;
import ch.csbe.productstore.Product.dto.ProductCreateDto;
import ch.csbe.productstore.Product.dto.ProductDetailDto;
import ch.csbe.productstore.Product.dto.ProductUpdateDto;
import ch.csbe.productstore.User.dto.LoginRequestDto;
import ch.csbe.productstore.User.dto.UserCreateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper (
        componentModel = "spring"
)
public abstract class UserMapper {


    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    public abstract User fromLoginRequestDto(LoginRequestDto loginRequestDto);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "email", target = "email")
    public abstract User fromUserCreateDto(UserCreateDto userCreateDto);

}

