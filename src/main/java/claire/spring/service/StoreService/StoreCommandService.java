package claire.spring.service.StoreService;

import claire.spring.domain.Store;
import claire.spring.web.dto.AddStoreRequest;

public interface StoreCommandService {
    Store addStore(AddStoreRequest.AddDto request);
}
