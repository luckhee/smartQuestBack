package kr.co.smartquest.application;

import kr.co.smartquest.domain.Entity.User;
import kr.co.smartquest.infrastructure.UserRepository;
import kr.co.smartquest.presentation.CreateUser.CreateUserRequestDto;
import kr.co.smartquest.presentation.CreateUser.CreateUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EnterUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public CreateUserResponseDto saveUser(CreateUserRequestDto createUserRequestDto) {
        String encodedPassword = passwordEncoder.encode(createUserRequestDto.getPassword());

        User user = new User(
                createUserRequestDto.getId(),
                createUserRequestDto.getName(),
                encodedPassword
        );

        userRepository.usersave(user);

        return new CreateUserResponseDto(user);
//        String id = createUserRequestDto.getId();
//        String name = createUserRequestDto.getName();
//        String password = createUserRequestDto.getPassword();
//
//        User user = new User(id, name, password);
//
//        userRepository.usersave(user);
//
//        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto(user);
//
//        return createUserResponseDto;
    }
}
