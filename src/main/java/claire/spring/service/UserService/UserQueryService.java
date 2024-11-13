package claire.spring.service.UserService;

import claire.spring.domain.dtos.UserDto;

public interface UserQueryService {
    UserDto getUserInfo(Long userId);
}
