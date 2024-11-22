package claire.spring.repository.UserMissionRepository;

import claire.spring.domain.enums.MissionStatus;
import claire.spring.domain.mapping.UserMission;
import org.springframework.data.domain.Page;

public interface UserMissionRepositoryCustom {
    void insertUserMission(UserMission userMission);

    int updateUserMissionStatus(Long userId, Long missionId, MissionStatus newStatus);

    Page<UserMission> findAllByUserIdAndStatus(Long userId, MissionStatus status, Integer page);
}
