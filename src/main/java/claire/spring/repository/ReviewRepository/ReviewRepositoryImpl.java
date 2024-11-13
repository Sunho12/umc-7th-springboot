package claire.spring.repository.ReviewRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {
    private final EntityManager entityManager;

    @Override
    public void insertReview(Long userId, Long missionId, Float rating, String title, String content, String imgUrl) {
        String sql = "INSERT INTO review (user_id, mission_id, rating, title, content, img_url, created_at, updated_at) " +
                "VALUES (:userId, :missionId, :rating, :title, :content, :imgUrl, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("userId", userId);
        query.setParameter("missionId", missionId);
        query.setParameter("rating", rating);
        query.setParameter("title", title);
        query.setParameter("content", content);
        query.setParameter("imgUrl", imgUrl);

        query.executeUpdate();
    }
}
