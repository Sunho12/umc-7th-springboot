package claire.spring.ApiPayload.exception.handler;

import claire.spring.ApiPayload.code.BaseErrorCode;
import claire.spring.ApiPayload.exception.GeneralException;

public class StoreHandler extends GeneralException {
    public StoreHandler(BaseErrorCode errorCode) { super(errorCode); }
}
