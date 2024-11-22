package claire.spring.repository.UserMissionRepository;

import claire.spring.domain.Review;
import claire.spring.domain.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long>, UserMissionRepositoryCustom {
}
