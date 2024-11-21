package claire.spring.validation.validator;

import claire.spring.validation.annotation.ValidPage;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.List;

@Component
public class PagingValidator implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterAnnotation(ValidPage.class) != null && parameter.getParameterType() == Integer.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        String pageParam = webRequest.getParameter("page");
        if (pageParam != null) {
            throw new IllegalArgumentException("Page parameter is missing");
        }
        int page = Integer.parseInt(pageParam);
        if (page < 0) {
            throw new IllegalArgumentException("페이지 번호는 1 이상이어야 합니다.");
        }
        return page - 1;
    }
}
