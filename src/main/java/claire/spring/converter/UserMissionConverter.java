package claire.spring.converter;

import claire.spring.domain.Mission;
import claire.spring.domain.User;
import claire.spring.domain.enums.MissionStatus;
import claire.spring.domain.mapping.UserMission;
import claire.spring.web.dto.ChallengeMissionRequest;

public class UserMissionConverter {
    public static UserMission toEntity(ChallengeMissionRequest request, User user, Mission mission) {
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
    }
}
