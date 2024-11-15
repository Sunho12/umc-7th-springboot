package claire.spring.web.controller;

import claire.spring.ApiPayload.ApiResponse;
import claire.spring.converter.UserMissionConverter;
import claire.spring.domain.mapping.UserMission;
import claire.spring.service.MissionService.MissionChallengeService;
import claire.spring.web.dto.ChallengeMissionRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class UserMissionRestController {
    private final MissionChallengeService missionChallengeService;

    @PostMapping("/challenge")
    public ApiResponse<String> challengeMission(@RequestBody @Valid ChallengeMissionRequest request) {
        UserMission userMission = missionChallengeService.addUserMission(request);
        return ApiResponse.onSuccess("미션 도전이 성공적으로 등록되었습니다.");
    }
}
