package kr.co.smartquest.presentation.Quest;

import kr.co.smartquest.domain.Entity.Quest;

import java.time.LocalDateTime;

public class QuestDto {
    private Long id;
    private String title;
    private String description;
    private Integer reward;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getReward() {
        return reward;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public QuestDto(Long id, String title, String description, Integer reward, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.reward = reward;
        this.createdAt = createdAt;
    }

    public QuestDto() {}

    public QuestDto(Quest quest) {
//        this.id = quest.getId();
        this.title = quest.getTitle();
        this.description = quest.getDescription();
        this.reward = quest.getReward();
//        this.createdAt = quest.getCreatedAt();
    }
}
