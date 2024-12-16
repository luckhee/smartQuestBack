package kr.co.smartquest.domain;

import kr.co.smartquest.domain.Entity.ChildRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ChildRefreshTokenRepository extends JpaRepository<ChildRefreshToken, Long> {
    Optional<ChildRefreshToken> findByChildId(Long id);
    Optional<ChildRefreshToken> findByRefreshtoken(String refreshToken);
}
