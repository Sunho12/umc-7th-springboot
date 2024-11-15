package claire.spring.ApiPayload.exception.handler;

import claire.spring.ApiPayload.code.BaseErrorCode;
import claire.spring.ApiPayload.exception.GeneralException;

public class UserMissionHandler extends GeneralException {
    public UserMissionHandler(BaseErrorCode errorCode) {super(errorCode);}
}
