package claire.spring.service.StoreService;

import claire.spring.domain.Mission;
import claire.spring.domain.Review;
import claire.spring.domain.Store;
import claire.spring.repository.MissionRepository.MissionRepository;
import claire.spring.repository.ReviewRepository.ReviewRepository;
import claire.spring.repository.StoreRepository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreQueryServiceImpl implements StoreQueryService {
    private final StoreRepository storeRepository;
    private final ReviewRepository reviewRepository;
    private final MissionRepository missionRepository;

    @Override
    public Optional<Store> findById(Long id) {
        return storeRepository.findById(id);
    }

    @Override
    public List<Store> findStoresByNameAndScore(String name, Float rating) {
        List<Store> filteredStores = storeRepository.dynamicQueryWithBooleanBuilder(name, rating);

        filteredStores.forEach(store -> System.out.println("Store: " + store));

        return filteredStores;
    }

    @Override
    public Page<Review> getReviewList(Long missionId, Integer page) {
        Mission mission = missionRepository.findById(missionId).get();

        Page<Review> MissionPage = reviewRepository.findAllByMission(mission, PageRequest.of(page, 10));
        return MissionPage;
    }
}
