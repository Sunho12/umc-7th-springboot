package claire.spring.service.ReviewService;

import claire.spring.repository.ReviewRepository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryServiceImpl implements ReviewQueryService {

    private final ReviewRepository reviewRepository;

    @Override
    public void insertReview(Long userId, Long missionId, Float rating, String title, String content, String imgUrl) {
        reviewRepository.insertReview(userId, missionId, rating, title, content, imgUrl);

    }
}
