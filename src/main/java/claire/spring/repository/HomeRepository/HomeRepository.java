package claire.spring.repository.HomeRepository;

import claire.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<User, Long>, HomeRepositoryCustom {
}
