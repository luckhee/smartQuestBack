package kr.co.smartquest.presentation.CreateUser;

import kr.co.smartquest.domain.Entity.User;

public class CreateUserResponseDto {
    private String id;
    private String password;



    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public CreateUserResponseDto(User user) {
        this.id = user.getId();
        this.password = user.getPassword();
    }
}
