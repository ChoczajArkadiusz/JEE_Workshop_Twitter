package pl.coderslab.spring.web.controler;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.spring.domain.model.User;
import pl.coderslab.spring.domain.repositories.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model) {
        model.addAttribute("newUser", new User());
        return "register";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("newUser") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        User userByEmail = userRepository.findByEmail(user.getEmail());
        User userByUsername = userRepository.findByUsername(user.getUsername());
        if (userByEmail != null) {
            result.rejectValue("email", null, "email już jest zajęty");
            return "register";
        }
        if (userByUsername != null) {
            result.rejectValue("username", null, "Nazwa użytkownika jest już zajęta");
            return "register";
        }
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/";
    }


}
