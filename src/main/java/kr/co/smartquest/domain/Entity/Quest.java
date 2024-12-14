package kr.co.smartquest.domain.Entity;

import jakarta.persistence.*;
import kr.co.smartquest.presentation.Quest.CreateQuestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Quest {
//    @NotNull
//    private Long id;
//    @NotNull
//    private String title;
//    @NotNull
//    private String description;
//
//    @Min(0)
//    @Max(10)
//    private Integer reward;
//
//    @NotNull
//    private LocalDateTime createdAt;
//
//    public Quest() {}
//
    public Quest(String title, String description, Integer reward) {
        this.title = title;
        this.description = description;
        this.reward = reward;
    }
//
    public Quest(CreateQuestDto createQuestDto, Parents parents, Children child) {
        this.parent = parents;
        this.title = createQuestDto.getTitle();
        this.description = createQuestDto.getDescription();
        this.reward = createQuestDto.getReward();
        this.child_id = child;
    }
//
//    public Integer getReward() {
//        return reward;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public LocalDateTime getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setReward(Integer reward) {
//        this.reward = reward;
//    }
//
//    public void setCreatedAt(LocalDateTime createdAt) {
//        this.createdAt = createdAt;
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quest_id", nullable = false)
    private Long quest_Id;

    @ManyToOne
    @JoinColumn(name = "parents_id", nullable = false)
    private Parents parent;

    @ManyToOne
    @JoinColumn(name = "child_id", nullable = false)
    private Children child_id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private Integer reward;

    @Column(name = "created_quest")
    private LocalDateTime createdQuest;

    @Column(name = "updated_quest")
    private LocalDateTime updatedQuest;

    @Column
    private String status;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @OneToMany(mappedBy = "quest")
    private List<Reward> rewards;
}
