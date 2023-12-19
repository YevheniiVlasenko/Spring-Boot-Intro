package project.bookstore.mapper;

import org.mapstruct.Mapper;
import project.bookstore.config.MapperConfig;
import project.bookstore.dto.user.UserDto;
import project.bookstore.dto.user.UserRegistrationRequestDto;
import project.bookstore.dto.user.UserResponseDto;
import project.bookstore.model.User;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    User toModel(UserRegistrationRequestDto createUserRequestDto);

    UserDto toDto(User user);

    UserResponseDto toResponseDto(User user);
}
