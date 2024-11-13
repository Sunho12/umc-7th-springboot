package claire.spring.repository.HomeRepository;

import claire.spring.domain.dtos.HomeDto;

import java.util.List;

public interface HomeRepositoryCustom {
    HomeDto getHomeInfo(Long userId, Long regionId, int offset, int limit);
}
