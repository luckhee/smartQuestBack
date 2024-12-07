package kr.co.smartquest.application;

import kr.co.smartquest.domain.Entity.Quest;

import kr.co.smartquest.infrastructure.QuestRepository;
import kr.co.smartquest.presentation.Quest.CreateQuestDto;
import kr.co.smartquest.presentation.Quest.QuestDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestService {

    private QuestRepository questRepository;
    private ModelMapper modelMapper;


    @Autowired
    public QuestService(QuestRepository questRepository, ModelMapper modelMapper) {
        this.questRepository = questRepository;
        this.modelMapper = modelMapper;

    }




    public void addQuest(CreateQuestDto createQuestDto) {
        Quest quest = new Quest(createQuestDto);
        questRepository.questSave(quest);
    }

    public List<QuestDto> findAllQuest() {
        List<Quest> quest = questRepository.findAllQuest();
        List<QuestDto> questDto = quest.stream()
                .map(quests -> modelMapper.map(quests, QuestDto.class))
                .toList();

        return questDto;
    }
}
