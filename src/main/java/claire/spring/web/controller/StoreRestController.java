package claire.spring.web.controller;

import claire.spring.ApiPayload.ApiResponse;
import claire.spring.service.StoreService.StoreCommandService;
import claire.spring.web.dto.AddStoreRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestController {
    private final StoreCommandService storeCommandService;

    @PostMapping("/add")
    public ApiResponse<String> addStore(@RequestBody @Valid AddStoreRequest.AddDto request) {
        storeCommandService.addStore(request);
        return ApiResponse.onSuccess("가게가 성공적으로 추가되었습니다.");
    }
}
