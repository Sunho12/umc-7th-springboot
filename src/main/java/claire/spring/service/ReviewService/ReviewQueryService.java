package claire.spring.service.ReviewService;

import claire.spring.domain.Review;
import claire.spring.repository.ReviewRepository.ReviewRepository;


public interface ReviewQueryService {
    void insertReview(Long userId, Long missionId, Float rating, String title, String content, String imgUrl);
}
