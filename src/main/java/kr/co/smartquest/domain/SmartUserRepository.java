package kr.co.smartquest.domain;


public interface SmartUserRepository {
    void usersave(User user);
    String findPasswordById(String id);

}
