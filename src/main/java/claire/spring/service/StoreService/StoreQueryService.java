package claire.spring.service.StoreService;

import claire.spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findById(Long id);
    List<Store> findStoresByNameAndScore(String name, Float rating);
}
