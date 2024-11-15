package claire.spring.service.MissionService;

import claire.spring.domain.mapping.UserMission;
import claire.spring.web.dto.ChallengeMissionRequest;

public interface MissionChallengeService {
    UserMission addUserMission(ChallengeMissionRequest request);
}
