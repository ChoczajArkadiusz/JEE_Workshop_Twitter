package pl.coderslab.spring.web.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring.domain.model.Message;
import pl.coderslab.spring.domain.model.Tweet;
import pl.coderslab.spring.domain.model.User;
import pl.coderslab.spring.domain.repositories.MessageRepository;
import pl.coderslab.spring.domain.repositories.TweetRepository;
import pl.coderslab.spring.domain.repositories.UserRepository;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/users/{id:[1-9][0-9]*}")
public class UserHistoryController {

    private TweetRepository tweetRepository;
    private UserRepository userRepository;
    private MessageRepository messageRepository;

    public UserHistoryController(TweetRepository tweetRepository, UserRepository userRepository, MessageRepository messageRepository) {
        this.tweetRepository = tweetRepository;
        this.userRepository = userRepository;
        this.messageRepository = messageRepository;
    }

    @ModelAttribute("userTweets")
    public List<Tweet> getUserTweets(@PathVariable Long id) {
        return tweetRepository.findAllByIdOrderByCreatedDesc(id);
    }

    @ModelAttribute("currentUser")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping
    public String prepareUserHistoryPage(Model model) {
        model.addAttribute("newMessage", new Message());
        return "user-history";
    }

    @PostMapping
    public String addMessage(@ModelAttribute("newMessage") @Valid Message message, BindingResult result,
                             @SessionAttribute(name = "user", required = false) User loggedUser,
                             @PathVariable Long id) {
        if (result.hasErrors()) {
            return "user-history";
        }
        if (loggedUser == null) {
            result.rejectValue("text", null, "Zaloguj się, aby przesłać wiadomość");
            return "user-history";
        }
        message.setSender(loggedUser);
        message.setReceiver(userRepository.findById(id));
        messageRepository.save(message);
        return "redirect:/";
    }


}