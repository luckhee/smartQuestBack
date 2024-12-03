package kr.co.smartquest.domain;

import java.util.List;

public interface SmartQuestRepository {
    void questSave(Quest quest);
    List<Quest> findAllQuest();
}
