package pl.coderslab.spring.web.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring.domain.model.User;
import pl.coderslab.spring.domain.repositories.UserRepository;

public class UserConverter implements Converter<String, User> {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User convert(String s) {
        return userRepository.findById(Long.parseLong(s));
    }
}
