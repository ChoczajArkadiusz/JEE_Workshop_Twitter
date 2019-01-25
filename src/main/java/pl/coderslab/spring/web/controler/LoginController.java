package pl.coderslab.spring.web.controler;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring.domain.model.User;
import pl.coderslab.spring.domain.repositories.UserRepository;
import pl.coderslab.spring.web.dto.LoginFormDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping
public class LoginController {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public LoginController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String prepareLoginForm(Model model) {
        model.addAttribute("loginFormDTO", new LoginFormDTO());
        return "login-form";
    }

    @PostMapping("/login")
    public String loginUser(@Valid LoginFormDTO loginFormDTO, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "login-form";
        }
        String encodedPassword = passwordEncoder.encode(loginFormDTO.getPassword());

        User user = userRepository.findByEmail(loginFormDTO.getEmail());
        if (user == null) {
            result.rejectValue("email", null, "Błędne dane logowania");
            return "login-form";
        }
        boolean matches = passwordEncoder.matches(loginFormDTO.getPassword(), user.getPassword());
        if (!matches) {
            result.rejectValue("email", null, "Błędne dane logowania");
            return "login-form";
        }

        session.setAttribute("user", user);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


}
