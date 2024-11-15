package claire.spring.service.ReviewService;

import claire.spring.domain.Review;
import claire.spring.domain.User;
import claire.spring.web.dto.ReviewRequest;


public interface ReviewCommandService {
    Review addReview(ReviewRequest.ReviewDto request);
}
