package claire.spring.ApiPayload.exception.handler;

import claire.spring.ApiPayload.code.BaseErrorCode;
import claire.spring.ApiPayload.exception.GeneralException;

public class ReviewHandler extends GeneralException {
    public ReviewHandler(BaseErrorCode code) {
        super(code);
    }
}