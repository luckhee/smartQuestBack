package kr.co.smartquest.domain;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import kr.co.smartquest.presentation.Quest.CreateQuestDto;
import kr.co.smartquest.presentation.Quest.QuestDto;

import java.time.LocalDateTime;

public class Quest {
    @NotNull
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;

    @Min(0)
    @Max(10)
    private Integer reward;

    @NotNull
    private LocalDateTime createdAt;

    public Quest() {}

    public Quest(String title, String description, Integer reward) {
        this.title = title;
        this.description = description;
        this.reward = reward;
    }

    public Quest(CreateQuestDto createQuestDto) {
        this.title = createQuestDto.getTitle();
        this.description = createQuestDto.getDescription();
        this.reward = createQuestDto.getReward();
    }

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
