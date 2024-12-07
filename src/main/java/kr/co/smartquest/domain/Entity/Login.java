package kr.co.smartquest.domain.Entity;

public class Login {
    private String id;
    private String password;

    public Login(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
