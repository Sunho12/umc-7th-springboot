package claire.spring.repository.UserRepository;

import claire.spring.domain.dtos.UserDto;

public interface UserRepositoryCustom {
    UserDto getUserInfo(Long userId);
}
