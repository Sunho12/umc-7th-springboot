package claire.spring.repository.UserRepository;

import claire.spring.domain.QUser;
import claire.spring.domain.dtos.UserDto;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QUser user = QUser.user;


    @Override
    public UserDto getUserInfo(Long userId) {
        return jpaQueryFactory
                .select(Projections.constructor(UserDto.class,
                        user.id,
                        user.name,
                        user.nickname,
                        user.address,
                        user.email,
                        user.phone_num,
                        user.point
                        ))
                .from(user)
                .where(user.id.eq(userId))
                .fetchOne();
    }
}
