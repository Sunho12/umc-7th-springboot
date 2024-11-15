package claire.spring.service.MissionService;

import claire.spring.ApiPayload.code.status.ErrorStatus;
import claire.spring.ApiPayload.exception.handler.UserMissionHandler;
import claire.spring.converter.ReviewConverter;
import claire.spring.converter.UserMissionConverter;
import claire.spring.domain.Mission;
import claire.spring.domain.Review;
import claire.spring.domain.User;
import claire.spring.domain.mapping.UserMission;
import claire.spring.repository.MissionRepository.MissionRepository;
import claire.spring.repository.ReviewRepository.ReviewRepository;
import claire.spring.repository.UserMissionRepository.UserMissionRepository;
import claire.spring.repository.UserRepository.UserRepository;
import claire.spring.service.ReviewService.ReviewCommandService;
import claire.spring.service.ReviewService.ReviewQueryService;
import claire.spring.web.dto.ChallengeMissionRequest;
import claire.spring.web.dto.ReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ErrorHandler;
import org.springframework.web.ErrorResponseException;

@Service
@RequiredArgsConstructor
@Transactional
public class MissionChallengeServiceImpl implements MissionChallengeService {
    private final UserMissionRepository userMissionRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;

    @Override
    public UserMission addUserMission(ChallengeMissionRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new UserMissionHandler(ErrorStatus.MEMBER_NOT_FOUND));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new UserMissionHandler(ErrorStatus.MISSION_NOT_FOUND));

        UserMission userMission = UserMissionConverter.toEntity(request, user, mission);
        return userMissionRepository.save(userMission);
    }
}
