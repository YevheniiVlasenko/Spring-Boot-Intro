package project.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.bookstore.dto.user.UserRegistrationRequestDto;
import project.bookstore.dto.user.UserResponseDto;
import project.bookstore.mapper.UserMapper;
import project.bookstore.model.User;
import project.bookstore.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final String REGISTRATION_EXCEPTION_MSG = "User with such email already exists!";
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto register(UserRegistrationRequestDto requestDto) {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RuntimeException(REGISTRATION_EXCEPTION_MSG);
        }
        User newUser = userMapper.toModel(requestDto);
        User savedUser = userRepository.save(newUser);
        return userMapper.toResponseDto(savedUser);
    }
}
