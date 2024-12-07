package kr.co.smartquest.domain;

import kr.co.smartquest.domain.Entity.Quest;

import java.util.List;

public interface SmartQuestRepository {
    void questSave(Quest quest);
    List<Quest> findAllQuest();
}
