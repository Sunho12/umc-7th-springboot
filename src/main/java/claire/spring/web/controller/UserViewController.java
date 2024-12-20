package claire.spring.web.controller;

import claire.spring.service.UserService.UserCommandService;
import claire.spring.web.dto.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserCommandService userCommandService;

    @PostMapping("/users/signup")
    public String joinUser(@ModelAttribute("UserJoinDto")UserRequest.JoinDto request,
                           BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        try {
            userCommandService.joinUser(request);
            return "redirect:/login";
        }catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "signup"; // 에러 발생 시 메세지 보내고 signup 페이지 유지
        }
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("userJoinDto", new UserRequest.JoinDto());
        return "signup";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
