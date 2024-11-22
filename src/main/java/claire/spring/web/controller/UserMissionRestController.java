package claire.spring.web.controller;

import claire.spring.ApiPayload.ApiResponse;
import claire.spring.converter.UserMissionConverter;
import claire.spring.domain.enums.MissionStatus;
import claire.spring.domain.mapping.UserMission;
import claire.spring.service.MissionService.MissionChallengeService;
import claire.spring.service.UserMissionService.UserMissionService;
import claire.spring.validation.annotation.ValidPage;
import claire.spring.web.dto.ChallengeMissionRequest;
import claire.spring.web.dto.UserMissionResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class UserMissionRestController {
    private final MissionChallengeService missionChallengeService;
    private final UserMissionService userMissionService;

    @PostMapping("/challenge")
    public ApiResponse<String> challengeMission(@RequestBody @Valid ChallengeMissionRequest request) {
        UserMission userMission = missionChallengeService.addUserMission(request);
        return ApiResponse.onSuccess("미션 도전이 성공적으로 등록되었습니다.");
    }

    @GetMapping("/{userId}/ongoing")
    @Operation(summary = "유저가 진행 중인 미션 목록 조회", description = "진행 중인 미션 목록을 페이징하여 반환합니다.")
    public ApiResponse<UserMissionResponse.userMissionResultListDTO> getOngoingMissions(
            @PathVariable Long userId,
            @ValidPage @RequestParam Integer page) {
        UserMissionResponse.userMissionResultListDTO response = userMissionService.getOngoingMissions(userId, MissionStatus.CHALLENGING, page);
        return ApiResponse.onSuccess(response);
    }
}
