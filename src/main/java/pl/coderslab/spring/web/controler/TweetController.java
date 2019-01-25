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
@RequestMapping("/tweet")
public class TweetController {

    TweetRepository tweetRepository;
    UserRepository userRepository;

    public TweetController(TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
    }

    @ModelAttribute("users")
    public List<User> users() {
        return userRepository.findAll();
    }


    @GetMapping("/all")
    public String prepareAuthorsPage(Model model) {
        model.addAttribute("tweets", tweetRepository.findAll());
        return "all-tweets";
    }

    @GetMapping({"/add", "edit"})
    public String prepareForm(@RequestParam(required = false) Long id, Model model) {
        Tweet tweet;
        if (id != null) tweet = tweetRepository.findById(id);
        else tweet = new Tweet();
        model.addAttribute("tweet", tweet);
        return "tweet-form";
    }

    @PostMapping({"/add", "/edit"})
    public String processForm(@Valid Tweet tweet, BindingResult result) {
        if (result.hasErrors()) {
            return "tweet-form";
        }
        tweetRepository.save(tweet);
        return "redirect:/tweet/all";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(required = false) Long id) {
        Tweet tweet = tweetRepository.findById(id);
        if (tweet == null) {
            return "redirect:/tweet/all";
        }
        tweetRepository.delete(tweet);
        return "redirect:/tweet/all";
    }


}
