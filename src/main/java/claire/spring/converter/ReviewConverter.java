package claire.spring.converter;

import claire.spring.domain.Mission;
import claire.spring.domain.Review;
import claire.spring.domain.User;
import claire.spring.web.dto.ReviewRequest;
import claire.spring.web.dto.ReviewResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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


    public static ReviewResponse.ReviewPreviewDTO reviewPreviewDTO(Review review) {
        return ReviewResponse.ReviewPreviewDTO.builder()
                .ownerNickname(review.getUser().getNickname())
                .rating(review.getRating())
                .createdAt(review.getCreatedAt())
                .content(review.getContent())
                .build();
    }
    public static ReviewResponse.ReviewPreviewListDTO reviewPreviewListDTO(Page<Review> reviewList) {

        List<ReviewResponse.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreviewDTO).collect(Collectors.toList());

        return ReviewResponse.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }
}
