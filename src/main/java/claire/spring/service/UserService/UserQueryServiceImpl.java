package claire.spring.service.UserService;

import claire.spring.domain.dtos.UserDto;
import claire.spring.repository.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserQueryServiceImpl implements UserQueryService {

    private final UserRepository userRepository;

    @Override
    public UserDto getUserInfo(Long userId) {
        return userRepository.getUserInfo(userId);
    }
}
