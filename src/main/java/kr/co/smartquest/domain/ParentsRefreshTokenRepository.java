package kr.co.smartquest.domain;

import kr.co.smartquest.domain.Entity.ParentsRefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ParentsRefreshTokenRepository extends JpaRepository<ParentsRefreshToken, Long> {
    Optional<ParentsRefreshToken> findByParentsid(Long id);
    Optional<ParentsRefreshToken> findByRefreshtoken(String refreshtoken);
}
