package claire.spring.service.UserMissionService;

import claire.spring.domain.enums.MissionStatus;
import claire.spring.domain.mapping.UserMission;
import claire.spring.repository.UserMissionRepository.UserMissionRepository;
import claire.spring.web.dto.UserMissionResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMissionServiceImpl implements UserMissionService {

    private final UserMissionRepository userMissionRepository;

    @Override
    public UserMissionResponse.userMissionResultListDTO getOngoingMissions(Long userId, MissionStatus status, Integer page) {
        Page<UserMission> missions = userMissionRepository.findAllByUserIdAndStatus(userId, status, page);

        List<UserMissionResponse.MissionResultDTO> missionList = missions.getContent().stream()
                .map(mission -> UserMissionResponse.MissionResultDTO.builder()
                        .missionId(mission.getMission().getId())
                        .missionName(mission.getMission().getName())
                        .content(mission.getMission().getContent())
                        .point(mission.getMission().getPoint())
                        .status(mission.getStatus())
                        .deadline(mission.getMission().getDeadline().atStartOfDay())
                        .build()).toList();

        return UserMissionResponse.userMissionResultListDTO.builder()
                .missionList(missionList)
                .listSize(missionList.size())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }

    @Override
    public boolean updateMissionStatus(Long userId, Long missionId, MissionStatus status) {
        return userMissionRepository.updateUserMissionStatus(userId, missionId, status) > 0;
    }

}
