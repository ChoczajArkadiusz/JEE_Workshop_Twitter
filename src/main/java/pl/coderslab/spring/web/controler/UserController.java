package pl.coderslab.spring.web.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring.domain.model.Tweet;
import pl.coderslab.spring.domain.model.User;
import pl.coderslab.spring.domain.repositories.TweetRepository;
import pl.coderslab.spring.domain.repositories.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    TweetRepository tweetRepository;
    UserRepository userRepository;

    public UserController(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/all")
    public String prepareAuthorsPage(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "all-users";
    }

    @GetMapping({"/add", "edit"})
    public String prepareForm(@RequestParam(required = false) Long id, Model model) {
        User user;
        if (id != null) user = userRepository.findById(id);
        else user = new User();
        model.addAttribute("user", user);
        return "user-form";
    }

    @PostMapping({"/add", "/edit"})
    public String processForm(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-form";
        }
        userRepository.save(user);
        return "redirect:/user/all";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(required = false) Long id) {
        User user = userRepository.findById(id);
        if (user == null) {
            return "redirect:/user/all";
        }
        user.getTweets().forEach(tweet -> {
            tweet.getUser().setTweets(null);
            tweetRepository.save(tweet);
        });

        userRepository.delete(user);
        return "redirect:/user/all";
    }


}
