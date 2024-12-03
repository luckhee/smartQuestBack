package kr.co.smartquest.infrastructure;

import kr.co.smartquest.domain.EntityNotFoundException;
import kr.co.smartquest.domain.SmartUserRepository;
import kr.co.smartquest.domain.User;
import kr.co.smartquest.presentation.CreateUser.CreateUserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements SmartUserRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void usersave(User user) {
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(user);

        namedParameterJdbcTemplate.update("INSERT INTO user (id, name, password) VALUES (:id, :name, :password)",
                namedParameters);
    }

    @Override
    public String findPasswordById(String id) {
        SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
        String password = null;

        try {
            password = namedParameterJdbcTemplate.queryForObject(
                    "SELECT password FROM user WHERE id = :id", namedParameters, String.class
            );
        } catch (EmptyResultDataAccessException e) {
            throw new EntityNotFoundException("id혹은비번을 확인하셈");
        }
        return password;
    }
}
