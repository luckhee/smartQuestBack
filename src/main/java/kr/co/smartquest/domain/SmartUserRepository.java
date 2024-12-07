package kr.co.smartquest.domain;


import kr.co.smartquest.domain.Entity.User;

public interface SmartUserRepository {
    void usersave(User user);
    String findPasswordById(String id);

}
