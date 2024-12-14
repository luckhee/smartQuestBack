package kr.co.smartquest.application;

import kr.co.smartquest.domain.Entity.Children;
import kr.co.smartquest.domain.Entity.Login;

import kr.co.smartquest.infrastructure.NewChildRepository;
import kr.co.smartquest.presentation.Login.TryLoginDto;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private final NewChildRepository newChildRepository;

    public LoginService(NewChildRepository newChildRepository) {
        this.newChildRepository = newChildRepository;
    }


//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public Children loadUserByUsername(String email) {
        return newChildRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException((email)));
    }



//    public Boolean login(TryLoginDto tryLoginDto) {
//        String storedPassword = userRepository.findPasswordById(tryLoginDto.getId());
//
////        return passwordEncoder.matches(tryLoginDto.getPassword(), storedPassword);
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
//        }
    }

