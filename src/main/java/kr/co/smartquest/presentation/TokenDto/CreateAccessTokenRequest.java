package kr.co.smartquest.presentation.TokenDto;


public class CreateAccessTokenRequest {
    private String refreshToken;

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
