package claire.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
public class AddStoreRequest {
    @Getter
    public static class AddDto {
        @NotNull
        private Long regionId;

        @NotNull(message = "가게 이름은 필수 입력 사항입니다.")
        @Size(min = 2, max = 50)
        private String name;

        @Size(max = 200)
        private String address;

        private Long categoryId;
    }
}
