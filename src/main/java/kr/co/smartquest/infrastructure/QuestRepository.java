package kr.co.smartquest.infrastructure;

import kr.co.smartquest.domain.Entity.Quest;
import kr.co.smartquest.domain.SmartQuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestRepository implements SmartQuestRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public QuestRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void questSave(Quest quest) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(quest);

        namedParameterJdbcTemplate.update("INSERT INTO quest (title, description, reward, createdAt) VALUES (:title, :description, :reward ,NOW())",
                namedParameters, keyHolder);

        Long id = keyHolder.getKey().longValue();
//        quest.setId(id);
    }

    @Override
    public List<Quest> findAllQuest() {
        List<Quest> quests = namedParameterJdbcTemplate.query(
                "SELECT * FROM quest",
                new BeanPropertyRowMapper<>(Quest.class)
        );

        return quests;

    }
}
