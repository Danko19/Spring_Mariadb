package com.example.sweater;

import com.example.sweater.domain.spring.spring.User;
import com.example.sweater.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {
    @Autowired
    private UserRepository userRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<User> messages = userRepo.findAll();

        model.put("messages", messages);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam Integer age, Map<String, Object> model) {
        User message = new User(name, age);

        userRepo.save(message);

        Iterable<User> users = userRepo.findAll();

        model.put("users", users);

        return "main";
    }
}
