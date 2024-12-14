package kr.co.smartquest.configuration;
//
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf-> csrf.disable()) // CSRF 보호 비활성화
                .authorizeHttpRequests(authz -> authz
                                // 회원가입, 로그인 엔드포인트는 모두 접근 허용
                                // 특정 요청과 일치하는 url에 대한 액세스를 설정
                                .requestMatchers("/smartquestUserInsert", "/smartquestLogin","/smartquestChildInsert","smartquestParentInsert")
                                // 누구나 접근 가능
                                .permitAll()
                                // 퀘스트 관련 API는 인증된 사용자만 접근 가능
                        .requestMatchers("/smartquestAdd/**").authenticated()
//                                // 나머지 요청은 인증 필요
                                .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin(formLogin -> formLogin
                        .loginProcessingUrl("/smartquestLogin")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/login?error=true")
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .invalidateHttpSession(true)// 로그아웃 이후에 세션 삭제 할지?
                );


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}


