package kr.co.smartquest.domain.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name="childrefreshtoken")
public class ChildRefreshToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false)
    private Long id;

    @Column(name ="child_id")
    private Long childId;

    @Column(name = "refresh_token")
    private String refreshtoken;

    public ChildRefreshToken(Long child_id, String refresh_token) {
        this.childId = child_id;
        this.refreshtoken = refresh_token;
    }

    public ChildRefreshToken update(String newRefreshToken) {
        this.refreshtoken = newRefreshToken;
        return this;
    }

}

