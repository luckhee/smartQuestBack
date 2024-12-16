package kr.co.smartquest.controller;

import kr.co.smartquest.application.Token.TokenService;
import kr.co.smartquest.presentation.TokenDto.CreateAccessTokenRequest;
import kr.co.smartquest.presentation.TokenDto.CreateAccessTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {
    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenResponse> createCToken(@RequestBody CreateAccessTokenRequest request) {
        String newAccessToken = tokenService.createNewChildAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateAccessTokenResponse(newAccessToken));
    }

    @PostMapping("/api/Ptoken")
    public ResponseEntity<CreateAccessTokenResponse> createPToken(@RequestBody CreateAccessTokenRequest request) {
        String newAccessToken = tokenService.createNewParentAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED).body(new CreateAccessTokenResponse(newAccessToken));
    }


}
