package kr.co.smartquest.presentation.Quest;

import java.time.LocalDateTime;

public class CreateQuestDto {
    private Long id;
    private String title;
    private String description;
    private Integer reward;

    public Integer getReward() {
        return reward;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
}
