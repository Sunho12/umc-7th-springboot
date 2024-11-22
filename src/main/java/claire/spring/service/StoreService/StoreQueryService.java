package claire.spring.service.StoreService;

import claire.spring.domain.Review;
import claire.spring.domain.Store;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {

    Optional<Store> findById(Long id);
    List<Store> findStoresByNameAndScore(String name, Float rating);

    Page<Review> getReviewList(Long storeId, Integer page);
}