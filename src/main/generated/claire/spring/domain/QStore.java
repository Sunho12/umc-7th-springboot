package claire.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 2089478318L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final StringPath address = createString("address");

    public final QCategory category;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final ListPath<Mission, QMission> missionList = this.<Mission, QMission>createList("missionList", Mission.class, QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final NumberPath<Float> rating = createNumber("rating", Float.class);

    public final QRegion region;

    public final ListPath<claire.spring.domain.mapping.StoreLikes, claire.spring.domain.mapping.QStoreLikes> storeLikesList = this.<claire.spring.domain.mapping.StoreLikes, claire.spring.domain.mapping.QStoreLikes>createList("storeLikesList", claire.spring.domain.mapping.StoreLikes.class, claire.spring.domain.mapping.QStoreLikes.class, PathInits.DIRECT2);

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

