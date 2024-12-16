package kr.co.smartquest.application.Token;

import kr.co.smartquest.application.EnterUserService;
import kr.co.smartquest.configuration.jwt.TokenProvider;
import kr.co.smartquest.domain.Entity.Children;
import kr.co.smartquest.domain.Entity.Parents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;

@RequiredArgsConstructor
@Service
public class TokenService {
    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final EnterUserService enterUserService;

    public String createNewChildAccessToken(String refreshToken) {
        //토큰 유효성 검사 실패하면 예외
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Invalid refresh token");
        }

        Long childId = refreshTokenService.findByChildRefreshToken(refreshToken).getChildId();
        Children children = enterUserService.findById(childId);

        return tokenProvider.generateToken(children, Duration.ofHours(2));
    }

    public String createNewParentAccessToken(String refreshToken) {
        if (!tokenProvider.validToken(refreshToken)) {
            throw new IllegalArgumentException("Invalid refresh token");
        }

        Long parentsId = refreshTokenService.findByParentRefreshToken(refreshToken).getParentsid();
        Parents parents = enterUserService.findParentid(parentsId);

        return tokenProvider.ParentgenerateToken(parents, Duration.ofHours(2));
    }
}
