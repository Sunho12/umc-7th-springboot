package claire.spring.converter;

import claire.spring.domain.User;
import claire.spring.domain.enums.Gender;
import claire.spring.web.dto.UserRequest;
import claire.spring.web.dto.UserResponse;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {
    public static UserResponse.JoinResultDto toJoinResultDto(User user) {
        return UserResponse.JoinResultDto.builder()
                .memberId(user.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static User toUser(UserRequest.JoinDto request) {
        return User.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .email(request.getEmail())
                .password(request.getPassword())
                .address(request.getAddress())
                .gender(Gender.valueOf(request.getGender()))
                .phone_num(request.getPhoneNum())
                .userPreferList(new ArrayList<>())
                .role(request.getRole())
                .build();
    }
}
