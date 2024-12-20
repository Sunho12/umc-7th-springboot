package claire.spring.service.UserService;

import claire.spring.ApiPayload.code.status.ErrorStatus;
import claire.spring.ApiPayload.exception.handler.FoodCategoryHandler;
import claire.spring.converter.UserConverter;
import claire.spring.converter.UserPreferConverter;
import claire.spring.domain.Category;
import claire.spring.domain.User;
import claire.spring.domain.mapping.UserPrefer;
import claire.spring.repository.FoodCategoryRepository.FoodCategoryRepository;
import claire.spring.repository.UserRepository.UserRepository;
import claire.spring.web.dto.UserRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User joinUser(UserRequest.JoinDto request){
        User newUser = UserConverter.toUser(request);

        newUser.encodePassword(passwordEncoder.encode(request.getPassword()));

        List<Category> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<UserPrefer> userPreferList = UserPreferConverter.toUserPreferList(foodCategoryList);

        userPreferList.forEach(userPrefer -> {userPrefer.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
