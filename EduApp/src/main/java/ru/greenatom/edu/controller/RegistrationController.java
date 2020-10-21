package ru.greenatom.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.greenatom.edu.domain.Role;
import ru.greenatom.edu.domain.User;
import ru.greenatom.edu.repository.UserRepository;

import java.util.Collections;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.addAttribute("message", "User already exists!");
            return "registration";
        }

        userFromDb.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        return "redirect:/login";
    }
}
