package claire.spring.repository.StoreRepository;

import claire.spring.domain.Store;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import claire.spring.domain.QStore;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final QStore store = QStore.store;

    @Override
    public List<Store> dynamicQueryWithBooleanBuilder(String name, Float rating) {

        if(name != null) {
            predicate.and(store.name.eq(name));
        }

        if(rating != null) {
            predicate.and(store.rating.goe(4.0f));
        }
        return jpaQueryFactory
                .selectFrom(store)
                .where(predicate)
                .fetch();
    }
}
