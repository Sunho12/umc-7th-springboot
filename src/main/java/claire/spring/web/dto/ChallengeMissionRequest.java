package claire.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ChallengeMissionRequest {
    @NotNull
    private Long userId;
    @NotNull
    private Long missionId;
}
