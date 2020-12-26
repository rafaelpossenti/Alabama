package com.possenti.task.controller;

import com.possenti.task.entity.Task;
import com.possenti.task.entity.User;
import com.possenti.task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(method = RequestMethod.GET)
    public String getAuthorizationMessage() {
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    //@PreAuthorize("hasRole('ROLE_USER')")
    public User save(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<User> get() {
        return repository.findAll();
    }

}