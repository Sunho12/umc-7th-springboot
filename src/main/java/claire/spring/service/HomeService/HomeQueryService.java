package claire.spring.service.HomeService;

import claire.spring.domain.dtos.HomeDto;

public interface HomeQueryService {
    HomeDto getHomeInfo(Long userId, Long regionId, int offset, int limit);
}
