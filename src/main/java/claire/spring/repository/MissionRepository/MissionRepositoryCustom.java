package claire.spring.repository.MissionRepository;

import claire.spring.domain.Mission;
import claire.spring.domain.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findMissionByUserIdAndStatus(Long userId, MissionStatus status, int offset, int limit);
}
