package claire.spring.repository.UserMissionRepository;

import claire.spring.domain.mapping.UserMission;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserMissionRepositoryImpl implements UserMissionRepositoryCustom{

    @Override
    public void insertUserMission(UserMission userMission) {

    }
}
