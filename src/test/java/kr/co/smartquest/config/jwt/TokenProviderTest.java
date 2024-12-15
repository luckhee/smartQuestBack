package kr.co.smartquest.config.jwt;

import io.jsonwebtoken.Jwts;
import kr.co.smartquest.configuration.jwt.JwtProperties;
import kr.co.smartquest.configuration.jwt.TokenProvider;
import kr.co.smartquest.domain.Entity.Children;
import kr.co.smartquest.infrastructure.NewChildRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Duration;
import java.util.Date;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
public class TokenProviderTest {
    @Autowired
    private TokenProvider tokenProvider;
    @Autowired
    private NewChildRepository newChildRepository;
    @Autowired
    private JwtProperties jwtProperties;

    @DisplayName("generateToken():유저 정보와 만료 기간을 전달해 토큰을 만들 수 있다.")
    @Test
    void generateToken() {
        // given
        Children testChild = newChildRepository.save(Children.builder()
                .name("may")
                .age(24)
                .email("user@gmail.com")
                .password("test").build());
        // when
        String token = tokenProvider.generateToken(testChild, Duration.ofDays(14));
        // then
        Long childId = Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody()
                .get("id", Long.class);

        assertThat(childId).isEqualTo(testChild.getChild_id());
    }

    @DisplayName("validation(): 만료된 토근인 때에 유효성 검증에 실패한다.")
    @Test
    void validToken_invalidToken() {
        String token = JwtFactory.builder()
                .expiration(new Date(new Date().getTime() - Duration.ofDays(7).toMillis()))
                .build()
                .createToken(jwtProperties);

        boolean result = tokenProvider.validToken(token);

        assertThat(result).isFalse();
    }

    @DisplayName("getAuthentication(): 토큰 기반으로 인증 정보를 가져올 수 있다.")
    @Test
    void getAuthentication() {
        String childEmail = "user@gmail.com";
        String token = JwtFactory.builder()
                .subject(childEmail)
                .build()
                .createToken(jwtProperties);

        Authentication authentication = tokenProvider.getAuthentication(token);

        assertThat(((UserDetails) authentication.getPrincipal()).getUsername()).isEqualTo(childEmail);
    }

    @DisplayName("getUserId() 토큰으로 유저 id를 가져올 수 있다")
    @Test
    void getUserId() {
        Long childId = 1L;
        String token = JwtFactory.builder()
                .claims(Map.of("id",childId))
                .build()
                .createToken(jwtProperties);

        Long userIdByToken = tokenProvider.getUserId(token);

        assertThat(userIdByToken).isEqualTo(childId);
    }



}
