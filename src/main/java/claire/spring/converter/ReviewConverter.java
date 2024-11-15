package claire.spring.converter;

import claire.spring.domain.Mission;
import claire.spring.domain.Review;
import claire.spring.domain.User;
import claire.spring.web.dto.ReviewRequest;
import claire.spring.web.dto.ReviewResponse;

public class ReviewConverter {

    public static ReviewResponse.ReviewResultDTO toReviewResultDTO(Review review) {
        return ReviewResponse.ReviewResultDTO.builder()
                .userId(review.getUser().getId())
                .missionId(review.getMission().getId())
                .content(review.getContent())
                .rating(review.getRating())
                .reviewDate(review.getCreatedAt())
                .build();
    }


    public static Review toReview(ReviewRequest.ReviewDto request, User user, Mission mission) {
        return Review.builder()
                .user(user)
                .mission(mission)
                .title(request.getTitle())
                .content(request.getContent())
                .rating(request.getRating())
                .build();
    }
}
