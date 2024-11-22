package claire.spring.web.controller;

import claire.spring.ApiPayload.ApiResponse;
import claire.spring.domain.enums.MissionStatus;
import claire.spring.service.MissionService.MissionQueryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionRestController {

    private final MissionQueryService missionQueryService;

    @PatchMapping("/{userId}/{missionId}/complete")
    @Operation(summary = "미션 COMPLETE 으로 바꾸는 API",description = "진행중인 미션 진행 완료로 바꾸는 API이며, query String 으로 userId, missionId를 주세요")
    public ApiResponse updateMissionStatusToComplete(
            @PathVariable("userId") Long userId, @PathVariable("missionId") Long missionId) {

        boolean updated = missionQueryService.updateMissionStatus(userId, missionId, MissionStatus.COMPLETE);

        if (updated) {
            return ApiResponse.onSuccess("미션 상태가 COMPLETE으로 업데이트되었습니다.");
        } else {
            return ApiResponse.onFailure(String.valueOf(HttpStatus.BAD_REQUEST), "미션 상태 업데이트에 실패했습니다.", null);
        }
    }
}
