package kr.co.smartquest.application;

import kr.co.smartquest.domain.Entity.Children;
import kr.co.smartquest.domain.Entity.Parents;
import kr.co.smartquest.domain.Entity.User;
import kr.co.smartquest.infrastructure.NewChildRepository;
import kr.co.smartquest.infrastructure.NewParentRepository;

import kr.co.smartquest.presentation.CreateUser.CreateUserRequestDto;
import kr.co.smartquest.presentation.CreateUser.CreateUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class EnterUserService {


    private NewChildRepository newChildRepository;
    private NewParentRepository newParentRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public EnterUserService(NewChildRepository newChildRepository,
                            NewParentRepository newParentRepository, PasswordEncoder passwordEncoder) {
        this.newChildRepository = newChildRepository;
        this.newParentRepository = newParentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void childSaveUser(CreateUserRequestDto requestDto) {
        Children children = new Children(requestDto); // 이거 해주는 이유가 객체에 값을 저장하고 새로 생성하는건데 이건 추후에 지워도 될듯 12/14
//        newChildRepository.save(children);
        newChildRepository.save(children.builder()
                .age(requestDto.getAge())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build()); // .getId()가 필요한지?
    }


    public void saveUser(CreateUserRequestDto requestDto) {
        Parents parents = new Parents(requestDto);
        newParentRepository.save(Parents.builder()
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .password(passwordEncoder.encode(requestDto.getPassword()))
                .build());
    }
//    @Autowired
//    private PasswordEncoder passwordEncoder;


//
//    public CreateUserResponseDto saveUser(CreateUserRequestDto createUserRequestDto) {
////        String encodedPassword = passwordEncoder.encode(createUserRequestDto.getPassword());
////
////        User user = new User(
////                createUserRequestDto.getId(),
////                createUserRequestDto.getName(),
////                encodedPassword
////        );
////
////        userRepository.usersave(user);
////
////        return new CreateUserResponseDto(user);
//
//        String name = createUserRequestDto.getName();
//        int age = createUserRequestDto.getAge();
//        String email = createUserRequestDto.getEmail();
//        String password = createUserRequestDto.getPassword();
//
//        Children children = new Children(name, age, email, password);
//
//        userRepository.usersave(user);
//
//        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto(user);
//
//        return createUserResponseDto;
//    }
}
