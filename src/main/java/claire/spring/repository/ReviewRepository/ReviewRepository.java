package claire.spring.repository.ReviewRepository;

import claire.spring.domain.Mission;
import claire.spring.domain.Review;
import claire.spring.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByMission(Mission mission, PageRequest pageRequest);

    void insertReview(Long userId, Long missionId, Float rating, String title, String content, String imgUrl);
}
