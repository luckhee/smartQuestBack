package kr.co.smartquest.application;

import kr.co.smartquest.domain.Login;
import kr.co.smartquest.infrastructure.UserRepository;
import kr.co.smartquest.presentation.Login.TryLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    public Boolean login(TryLoginDto tryLoginDto) {
        String storedPassword = userRepository.findPasswordById(tryLoginDto.getId());

        return passwordEncoder.matches(tryLoginDto.getPassword(), storedPassword);
//        Boolean result = false;
//        String id = tryLoginDto.getId();
//        String password = tryLoginDto.getPassword();
//
//        Login login = new Login(id, password);
//
//        String savedpassword = userRepository.findPasswordById(id);
//
//        if(savedpassword == null) {
//            return result;
//        } else if(savedpassword.equals(password)) {
//            return result = true;
//        }
//        return result;
        }
    }

