package claire.spring.repository.UserMissionRepository;

import claire.spring.domain.User;
import claire.spring.domain.enums.MissionStatus;
import claire.spring.domain.mapping.UserMission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class UserMissionRepositoryImpl implements UserMissionRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<UserMission> findAllByUserIdAndStatus(Long userId, MissionStatus status, Integer page) {
        return null;
    }

    @Override
    public void insertUserMission(UserMission userMission) {

    }

    @Override
    @Transactional
    public int updateUserMissionStatus(Long userId, Long missionId, MissionStatus newStatus) {
        String jpql = "UPDATE UserMission um " +
                "SET um.status = :newStatus " +
                "WHERE um.user.id = :userId AND um.mission.id = :missionId";

        return entityManager.createQuery(jpql)
                .setParameter("newStatus", newStatus)
                .setParameter("userId", userId)
                .setParameter("missionId", missionId)
                .executeUpdate();
    }

}
