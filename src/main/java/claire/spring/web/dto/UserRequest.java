package claire.spring.web.dto;

import claire.spring.domain.enums.Role;
import claire.spring.validation.annotation.ExistCategories;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserRequest {
    @Getter
    @Setter // thymeleaf 에서 사용하기 위해 추가
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        String nickname;
        @NotNull
        String gender;
        @NotNull
        @Email
        String email;
        @NotBlank
        String password;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 20)
        String phoneNum;
        @ExistCategories
        List<Long> preferCategory;
        @NotNull
        Role role;
    }
}
