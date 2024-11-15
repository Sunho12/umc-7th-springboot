package claire.spring.service.ReviewService;

import claire.spring.converter.ReviewConverter;
import claire.spring.domain.Mission;
import claire.spring.domain.Review;
import claire.spring.domain.User;
import claire.spring.repository.MissionRepository.MissionRepository;
import claire.spring.repository.ReviewRepository.ReviewRepository;
import claire.spring.repository.UserRepository.UserRepository;
import claire.spring.web.dto.ReviewRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;


    @Override
    @Transactional
    public Review addReview(ReviewRequest.ReviewDto request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 미션입니다."));

        Review review = ReviewConverter.toReview(request, user, mission);
        return reviewRepository.save(review);
    }


}
