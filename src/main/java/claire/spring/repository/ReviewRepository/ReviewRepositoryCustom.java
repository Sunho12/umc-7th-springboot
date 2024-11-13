package claire.spring.repository.ReviewRepository;

import claire.spring.domain.Review;

public interface ReviewRepositoryCustom {
    void insertReview(Long userId, Long missionId, Float rating, String title, String content, String imgUrl);
}
