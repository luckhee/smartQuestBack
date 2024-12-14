package kr.co.smartquest.application;

import kr.co.smartquest.domain.Entity.Children;
import kr.co.smartquest.domain.Entity.Parents;
import kr.co.smartquest.domain.Entity.Quest;

import kr.co.smartquest.infrastructure.NewChildRepository;
import kr.co.smartquest.infrastructure.NewParentRepository;
import kr.co.smartquest.infrastructure.NewQuestRepository;
import kr.co.smartquest.infrastructure.QuestRepository;
import kr.co.smartquest.presentation.Quest.CreateQuestDto;
import kr.co.smartquest.presentation.Quest.QuestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {

    private final NewParentRepository newParentRepository;
    private final NewChildRepository newChildRepository;
    private QuestRepository questRepository;
    private ModelMapper modelMapper;
    private NewQuestRepository newQuestRepository;


    @Autowired
    public QuestService(QuestRepository questRepository, ModelMapper modelMapper, NewQuestRepository newQuestRepository, NewParentRepository newParentRepository, NewChildRepository newChildRepository) {
        this.questRepository = questRepository;
        this.modelMapper = modelMapper;
        this.newQuestRepository = newQuestRepository;
        this.newParentRepository = newParentRepository;
        this.newChildRepository = newChildRepository;
    }




    public void addQuest(CreateQuestDto createQuestDto) {
        Parents parents = newParentRepository.findById(createQuestDto.getParent_id())
                .orElseThrow(() -> new RuntimeException("parent not fount"));

        Children child = newChildRepository.findById(createQuestDto.getChild_id()).
                orElseThrow(() -> new RuntimeException("child not fount"));

        Quest quest = new Quest(createQuestDto, parents, child);
        newQuestRepository.save(quest);
    }

    public List<QuestDto> findAllQuest() {
        List<Quest> quest = questRepository.findAllQuest();
        List<QuestDto> questDto = quest.stream()
                .map(quests -> modelMapper.map(quests, QuestDto.class))
                .toList();

        return questDto;
    }
}
