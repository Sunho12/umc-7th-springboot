package claire.spring.service.HomeService;

import claire.spring.domain.dtos.HomeDto;
import claire.spring.repository.HomeRepository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class HomeQueryServiceImpl implements HomeQueryService {

    private final HomeRepository homeRepository;

    @Override
    public HomeDto getHomeInfo(Long userId, Long regionId, int offset, int limit) {
        return homeRepository.getHomeInfo(userId, regionId, offset, limit);
    }
}
