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
@RequestMapping("/")
public class HomeController {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;

    public HomeController(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("allTweets")
    public List<Tweet> allTweets() {
        return tweetRepository.findAllOrderByCreatedDesc();
    }

    @GetMapping
    public String prepareHomePage(Model model) {
        model.addAttribute("newTweet", new Tweet());
        return "homepage";
    }

    @PostMapping
    public String addTweet(@ModelAttribute("newTweet") @Valid Tweet tweet, BindingResult result,
                           @SessionAttribute(name="user", required = false) User user) {
        if (result.hasErrors()) {
            return "homepage";
        }
        if (user == null) {
            result.rejectValue("text", null, "Zaloguj się, aby dodać tweet'a");
            return "homepage";
        }
        tweet.setUser(user);
        tweetRepository.save(tweet);
        return "redirect:/";
    }


}