package kr.co.smartquest.presentation.CreateUser;

public class CreateUserRequestDto {
    private String id;
    private String name;
    private String password;

    public CreateUserRequestDto() {}

    public CreateUserRequestDto( String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
