package pl.coderslab.spring.web.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring.domain.model.Tweet;
import pl.coderslab.spring.domain.repositories.TweetRepository;

import java.util.List;

@Controller
public class HomeController {

    TweetRepository tweetRepository;

    public HomeController(TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    @GetMapping
    public String prepareHomePage() {
        return "index";
    }

    @GetMapping("/user/{id:[1-9][0-9]*}/tweets")
    public String prepareTweets1(@PathVariable Long id, Model model) {
        List<Tweet> tweets = tweetRepository.findAllByUserId(id);
        if (tweets == null) {
            return "Nie znaleziono tweetow";
        }
        model.addAttribute("tweets", tweets);
        return "tweets";
    }

    @GetMapping("/user/search-tweets")
    public String prepareTweets2(String phrase, Model model) {
        List<Tweet> tweets = tweetRepository.findAllStartingWith(phrase);
        if (tweets == null) {
            return "Nie znaleziono tweetow";
        }
        model.addAttribute("tweets", tweets);
        return "tweets";
    }


}
