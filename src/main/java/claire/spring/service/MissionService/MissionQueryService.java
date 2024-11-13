package claire.spring.service.MissionService;

import claire.spring.domain.Mission;
import claire.spring.domain.enums.MissionStatus;
import claire.spring.repository.MissionRepository.MissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MissionQueryService {
    List<Mission> getMissionByUserIdAndStatus(Long userId, MissionStatus status, int offset, int limit);
}
