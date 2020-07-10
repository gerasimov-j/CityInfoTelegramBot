package by.gerasimov.service;

import by.gerasimov.model.Country;
import by.gerasimov.model.User;
import by.gerasimov.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByChatId(long chatId) {
        return userRepository.findByChatId(chatId);
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }
}
