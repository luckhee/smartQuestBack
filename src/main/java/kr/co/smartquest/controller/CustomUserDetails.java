package kr.co.smartquest.application.Service;

import kr.co.smartquest.domain.Entity.Children;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {
    private final Children children;

    public CustomUserDetails(Children children) {
        this.children = children;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 정보 반환 (필요 시 설정)
        return null;
    }

    @Override
    public String getPassword() {
        return children.getPassword(); // Children 엔티티의 비밀번호
    }

    @Override
    public String getUsername() {
        return children.getEmail(); // Children 엔티티의 이메일
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // 계정 만료 여부
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // 계정 잠금 여부
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // 자격 증명 만료 여부
    }

    @Override
    public boolean isEnabled() {
        return true; // 계정 활성화 여부
    }

    public Children getChildren() {
        return children; // 원래 엔티티 객체 반환 (필요 시)
    }
}
