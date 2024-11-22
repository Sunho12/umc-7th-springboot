package claire.spring.web.controller;

import claire.spring.ApiPayload.ApiResponse;
import claire.spring.converter.ReviewConverter;
import claire.spring.domain.Review;
import claire.spring.service.ReviewService.ReviewCommandService;
import claire.spring.web.dto.ReviewRequest;
import claire.spring.web.dto.ReviewResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponse.ReviewResultDTO> addReview(@Validated @RequestBody ReviewRequest.ReviewDto request) {
        Review review = reviewCommandService.addReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toReviewResultDTO(review));
    }

}
