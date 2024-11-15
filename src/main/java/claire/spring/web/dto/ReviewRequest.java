package claire.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class ReviewRequest {

    @Getter
    public static class ReviewDto{
        @NotNull
        private Long userId;
        @NotNull
        private Long missionId;
        @NotNull
        @Size(min = 1, max = 50)
        private String title;
        @NotNull
        @Size(min = 1, max = 200)
        private String content;
        @NotNull
        private Float rating;
    }
}
