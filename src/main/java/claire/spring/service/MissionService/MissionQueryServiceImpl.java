package claire.spring.service.MissionService;

import claire.spring.domain.Mission;
import claire.spring.domain.enums.MissionStatus;
import claire.spring.repository.MissionRepository.MissionRepository;
import claire.spring.repository.UserMissionRepository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public List<Mission> getMissionByUserIdAndStatus(Long userId, MissionStatus status, int offset, int limit) {
        List<Mission> missions = missionRepository.findMissionByUserIdAndStatus(userId, status, offset, limit);
        return missions;
    }

    @Override
    @Transactional
    public boolean updateMissionStatus(Long userId, Long missionId, MissionStatus status) {
        return userMissionRepository.updateUserMissionStatus(userId, missionId, status) > 0;
    }
}
