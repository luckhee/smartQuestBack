package kr.co.smartquest.presentation.CreateUser;

public class CreateUserRequestDto {
    private String name;
    private int age;
    private String email;
    private String password;

    public CreateUserRequestDto() {}

    public CreateUserRequestDto( String name, int age, String email,String password) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
