package kr.co.smartquest.presentation.Quest;

import jakarta.persistence.*;
import kr.co.smartquest.domain.Entity.Children;
import kr.co.smartquest.domain.Entity.Parents;

import java.time.LocalDateTime;

public class CreateQuestDto {

    private Long quest_Id;

    private Long parent_id;

    private Long child_id;

    private String title;

    private String description;

    private Integer reward;

//    private LocalDateTime createdQuest;
//
//    private LocalDateTime updatedQuest;

    private String status;
//
//    private LocalDateTime dueDate;

    public Long getQuest_Id() {
        return quest_Id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public Long getChild_id() {
        return child_id;
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

//    public LocalDateTime getCreatedQuest() {
//        return createdQuest;
//    }
//
//    public LocalDateTime getUpdatedQuest() {
//        return updatedQuest;
//    }

    public String getStatus() {
        return status;
    }

//    public LocalDateTime getDueDate() {
//        return dueDate;
//    }
}
