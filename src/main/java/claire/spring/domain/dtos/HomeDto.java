package claire.spring.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeDto {
    private Integer userPoints;
    private String userName;
    private String regionName;
    private List<MissionInfo> missions;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionInfo {
        private String storeName;
        private String categoryName;
        private String missionContent;
        private Integer missionPoints;
        private String deadline;
    }

}
