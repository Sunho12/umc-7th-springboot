package claire.spring.repository.MissionRepository;

import claire.spring.domain.Mission;
import claire.spring.domain.QMission;
import claire.spring.domain.enums.MissionStatus;
import claire.spring.domain.mapping.QUserMission;
import claire.spring.domain.mapping.UserMission;
import claire.spring.repository.UserMissionRepository.UserMissionRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QUserMission userMission = QUserMission.userMission;
    private final UserMissionRepository userMissionRepository;

    @Override
    public List<Mission> findMissionByUserIdAndStatus(Long userId, MissionStatus status, int offset, int limit) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(userId != null){
            predicate.and(userMission.user.id.eq(userId));
        }

        if(status != null){
            predicate.and(userMission.status.eq(status));
        }

        return jpaQueryFactory
                .selectFrom(mission)
                .join(userMission).on(userMission.mission.id.eq(mission.id))
                .where(predicate)
                .fetch();
    }

}
