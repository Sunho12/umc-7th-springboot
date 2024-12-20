package claire.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -71086498L;

    public static final QUser user = new QUser("user");

    public final claire.spring.domain.common.QBaseEntity _super = new claire.spring.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final ListPath<Comment, QComment> commentList = this.<Comment, QComment>createList("commentList", Comment.class, QComment.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<claire.spring.domain.enums.Gender> gender = createEnum("gender", claire.spring.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public final StringPath phone_num = createString("phone_num");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<claire.spring.domain.enums.Role> role = createEnum("role", claire.spring.domain.enums.Role.class);

    public final EnumPath<claire.spring.domain.enums.SocialType> socialType = createEnum("socialType", claire.spring.domain.enums.SocialType.class);

    public final EnumPath<claire.spring.domain.enums.MemberStatus> status = createEnum("status", claire.spring.domain.enums.MemberStatus.class);

    public final ListPath<claire.spring.domain.mapping.StoreLikes, claire.spring.domain.mapping.QStoreLikes> storeLikesList = this.<claire.spring.domain.mapping.StoreLikes, claire.spring.domain.mapping.QStoreLikes>createList("storeLikesList", claire.spring.domain.mapping.StoreLikes.class, claire.spring.domain.mapping.QStoreLikes.class, PathInits.DIRECT2);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<claire.spring.domain.mapping.UserAgree, claire.spring.domain.mapping.QUserAgree> userAgreeList = this.<claire.spring.domain.mapping.UserAgree, claire.spring.domain.mapping.QUserAgree>createList("userAgreeList", claire.spring.domain.mapping.UserAgree.class, claire.spring.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public final ListPath<claire.spring.domain.mapping.UserMission, claire.spring.domain.mapping.QUserMission> userMissionList = this.<claire.spring.domain.mapping.UserMission, claire.spring.domain.mapping.QUserMission>createList("userMissionList", claire.spring.domain.mapping.UserMission.class, claire.spring.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public final ListPath<claire.spring.domain.mapping.UserPrefer, claire.spring.domain.mapping.QUserPrefer> userPreferList = this.<claire.spring.domain.mapping.UserPrefer, claire.spring.domain.mapping.QUserPrefer>createList("userPreferList", claire.spring.domain.mapping.UserPrefer.class, claire.spring.domain.mapping.QUserPrefer.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

