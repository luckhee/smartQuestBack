package kr.co.smartquest.controller;

import kr.co.smartquest.application.EnterUserService;
import kr.co.smartquest.application.LoginService;
import kr.co.smartquest.application.QuestService;
import kr.co.smartquest.presentation.CreateUser.CreateUserRequestDto;
import kr.co.smartquest.presentation.CreateUser.CreateUserResponseDto;
import kr.co.smartquest.presentation.Login.TryLoginDto;
import kr.co.smartquest.presentation.Quest.CreateQuestDto;
import kr.co.smartquest.presentation.Quest.QuestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class SmartQuestController {

    private EnterUserService enterUserService;
    private LoginService loginService;
    private QuestService questService;

    @Autowired
    public SmartQuestController(EnterUserService enterUserService, LoginService loginService, QuestService questService) {
        this.enterUserService = enterUserService;
        this.loginService = loginService;
        this.questService = questService;
    }

    //회원가입 API
    @RequestMapping(value= "/smartquestUserInsert", method = RequestMethod.POST)
    public void createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        CreateUserResponseDto createUserResponseDto = enterUserService.saveUser(createUserRequestDto);

    }

    //로그인 API result가 true면 리턴타입을 ResponseEntity<BatchQuest>로 간다던지
    @RequestMapping(value = "/smartquestLogin", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody TryLoginDto tryLoginDto) {
        Boolean result = loginService.login(tryLoginDto);

        return ok(result);
    }

    //퀘스트 추가 API
    @RequestMapping(value = "/smartquestAdd", method = RequestMethod.POST)
    public ResponseEntity<String> addQuest(@RequestBody CreateQuestDto createQuestDto) {
        questService.addQuest(createQuestDto);

        return ResponseEntity.ok("success");
    }

    //퀘스트 확인 API
    @RequestMapping(value="/smartquestAdd", method = RequestMethod.GET)
    public List<QuestDto> findQuest() {
        return questService.findAllQuest();
    }
}
