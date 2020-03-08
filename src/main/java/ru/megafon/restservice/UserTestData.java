package ru.megafon.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.megafon.restservice.model.User;
import ru.megafon.restservice.model.repository.UserRepository;

import javax.annotation.PostConstruct;

@Component
public class UserTestData {
    private final UserRepository userRepository;

    @Autowired
    public UserTestData(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initTestData() {
        userRepository.save(User.createUser("admin", User.Role.ADMINISTRATOR, "admin"));
        userRepository.save(User.createUser("user", User.Role.USER,"user"));
    }
}
