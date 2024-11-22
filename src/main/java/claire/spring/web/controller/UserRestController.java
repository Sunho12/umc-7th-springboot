package claire.spring.web.controller;

import claire.spring.ApiPayload.ApiResponse;
import claire.spring.converter.UserConverter;
import claire.spring.domain.User;
import claire.spring.service.UserService.UserCommandService;
import claire.spring.web.dto.UserRequest;
import claire.spring.web.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {
    private final UserCommandService userCommandService;

    @PostMapping("/")
    public ApiResponse<UserResponse.JoinResultDto> join(@RequestBody @Valid UserRequest.JoinDto request){
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDto(user));
    }

}
