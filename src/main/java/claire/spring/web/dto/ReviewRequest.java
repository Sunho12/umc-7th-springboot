package claire.spring.web.dto;

import lombok.Getter;

public class ReviewRequest {

    @Getter
    public static class ReviewDto{
        private Long userId;
        private Long missionId;
        private String title;
        private String content;
        private Float rating;
    }
}
