package kr.co.smartquest.configuration;


import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

public class WebSecurityConfig{

    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .usernameParameter("email")
                .passwordParameter("password");
    }

}
