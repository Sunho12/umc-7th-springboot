package claire.spring.service.UserMissionService;

import claire.spring.domain.enums.MissionStatus;
import claire.spring.web.dto.UserMissionResponse;
import jakarta.transaction.Transactional;

public interface UserMissionService {
    public UserMissionResponse.userMissionResultListDTO getOngoingMissions(Long userId, MissionStatus status, Integer page);

    boolean updateMissionStatus(Long userId, Long missionId, MissionStatus status);
}
