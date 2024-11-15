package claire.spring.service.StoreService;

import claire.spring.ApiPayload.code.status.ErrorStatus;
import claire.spring.ApiPayload.exception.handler.StoreHandler;
import claire.spring.domain.Category;
import claire.spring.domain.Region;
import claire.spring.domain.Store;
import claire.spring.repository.FoodCategoryRepository.FoodCategoryRepository;
import claire.spring.repository.RegionRepository.RegionRepository;
import claire.spring.repository.StoreRepository.StoreRepository;
import claire.spring.web.dto.AddStoreRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final RegionRepository regionRepository;
    private final StoreRepository storeRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Store addStore(AddStoreRequest.AddDto request) {
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.REGION_NOT_FOUND));
        Category category = foodCategoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));

        Store store = Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .category(category)
                .build();

        return storeRepository.save(store);
    }
}
