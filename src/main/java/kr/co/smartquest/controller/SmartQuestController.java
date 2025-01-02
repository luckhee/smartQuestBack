package kr.co.smartquest.presentation.controller;

import kr.co.smartquest.application.Service.EnterUserService;
import kr.co.smartquest.application.Service.LoginService;
import kr.co.smartquest.application.Service.QuestService;
import kr.co.smartquest.presentation.CreateUser.CreateUserRequestDto;
import kr.co.smartquest.presentation.Login.TryLoginDto;
import kr.co.smartquest.presentation.Quest.CreateQuestDto;
import kr.co.smartquest.presentation.Quest.QuestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //회원가입 API 완료.
    @RequestMapping(value= "/smartquestParentInsert", method = RequestMethod.POST)
    public ResponseEntity<?> createParentUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
//        CreateUserResponseDto createUserResponseDto = enterUserService.saveUser(createUserRequestDto);
        enterUserService.saveUser(createUserRequestDto);

        return ResponseEntity.ok("저장완");
    }
    // 자식 회원가입
    @RequestMapping(value= "/smartquestChildInsert", method = RequestMethod.POST)
    public ResponseEntity<?> createChildUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
//        CreateUserResponseDto createUserResponseDto = enterUserService.saveUser(createUserRequestDto);
        enterUserService.childSaveUser(createUserRequestDto);

        return ResponseEntity.ok("저장완");
    }

    //로그인 API result가 true면 리턴타입을 ResponseEntity<BatchQuest>로 간다던지
    @RequestMapping(value = "/smartquestLogin", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody TryLoginDto tryLoginDto) {
        String email = tryLoginDto.getEmail();
        loginService.loadUserByUsername(email);
        Map<String, String> response = new HashMap<>();
        response.put("message", "로그인 완료");
        return ResponseEntity.ok(response);
    }

    //퀘스트 추가 API 완료.
    @PostMapping("/smartquestAdd")
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
