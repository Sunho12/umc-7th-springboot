package claire.spring.ApiPayload.exception.handler;

import claire.spring.ApiPayload.code.BaseErrorCode;
import claire.spring.ApiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
