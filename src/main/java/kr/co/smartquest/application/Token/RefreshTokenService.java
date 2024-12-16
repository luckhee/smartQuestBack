package kr.co.smartquest.application.Token;

import kr.co.smartquest.domain.ChildRefreshTokenRepository;
import kr.co.smartquest.domain.Entity.ChildRefreshToken;
import kr.co.smartquest.domain.Entity.ParentsRefreshToken;
import kr.co.smartquest.domain.ParentsRefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RefreshTokenService {
    private final ChildRefreshTokenRepository childRefreshTokenRepository;
    private final ParentsRefreshTokenRepository parentsRefreshTokenRepository;

    public ChildRefreshToken findByChildRefreshToken(String refreshToken) {
        return childRefreshTokenRepository.findByRefreshtoken(refreshToken).orElseThrow(()-> new IllegalArgumentException("unexpected toekn"));
    }

    public ParentsRefreshToken findByParentRefreshToken(String refreshToken) {
        return parentsRefreshTokenRepository.findByRefreshtoken(refreshToken).orElseThrow(()-> new IllegalArgumentException("unexpected toekn"));
    }
}
