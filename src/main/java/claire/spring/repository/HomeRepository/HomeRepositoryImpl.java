package claire.spring.repository.HomeRepository;

import claire.spring.domain.*;
import claire.spring.domain.dtos.HomeDto;
import claire.spring.domain.enums.MissionStatus;
import claire.spring.domain.mapping.QUserMission;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class HomeRepositoryImpl implements HomeRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;
    private final QMission mission = QMission.mission;
    private final QRegion region = QRegion.region;
    private final QStore store = QStore.store;
    private final QCategory category = QCategory.category;
    private final QUserMission userMission = QUserMission.userMission;

    @Override
    public HomeDto getHomeInfo(Long userId, Long regionId, int offset, int limit) {
        Integer userPoints = jpaQueryFactory
                .select(user.point)
                .from(user)
                .where(user.id.eq(userId))
                .fetchOne();

        String userName = jpaQueryFactory
                .select(user.name)
                .from(user)
                .where(user.id.eq(userId))
                .fetchOne();

        String regionName = jpaQueryFactory
                .select(region.name)
                .from(region)
                .where(region.id.eq(regionId))
                .fetchOne();

        // 도전 가능한 미션 목록 쿼리
        List<HomeDto.MissionInfo> missions = jpaQueryFactory
                .select(Projections.constructor(HomeDto.MissionInfo.class,
                        store.name,
                        category.name,
                        mission.content,
                        mission.point,
                        mission.deadline.stringValue()
                ))
                .from(mission)
                .join(store).on(mission.store.id.eq(store.id))
                .join(category).on(store.category.id.eq(category.id))
                .join(region).on(store.region.id.eq(region.id))
                .join(userMission).on(mission.id.eq(userMission.mission.id))
                .leftJoin(userMission)
                .on(mission.id.eq(userMission.mission.id)
                        .and(userMission.user.id.eq(userId))
                        .and(userMission.status.eq(MissionStatus.COMPLETE).not()))
                .where(region.id.eq(regionId))
                .offset(offset)
                .limit(limit)
                .fetch();

        return new HomeDto(userPoints, userName, regionName,missions);
}}
