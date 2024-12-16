package kr.co.smartquest.domain.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "parentrefreshtoken")
public class ParentsRefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "parents_id")
    private Long parentsid;

    @Column(name = "refresh_token")
    private String refreshtoken;

    public ParentsRefreshToken(Long parents_id, String refresh_token) {
        this.parentsid = parents_id;
        this.refreshtoken = refresh_token;
    }

    public ParentsRefreshToken update(String newRefreshToken) {
        this.refreshtoken = newRefreshToken;
        return this;
    }

}
