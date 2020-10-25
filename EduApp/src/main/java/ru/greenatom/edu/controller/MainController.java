package ru.greenatom.edu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.greenatom.edu.domain.Message;
import ru.greenatom.edu.domain.User;
import ru.greenatom.edu.repository.MessageRepository;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MessageRepository messageRepo;

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,  Model model) {
        model.addAttribute("something", "Hello, again!");
        Iterable<Message> messages = messageRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        } else {
            messages = messageRepo.findAll();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String text,
            @RequestParam String tag,
            Model model) {
        Message message = new Message(text, tag, user);
        messageRepo.save(message);
        // Так делать не надо вообще, но для обучения норм
        Iterable<Message> messageRepoAll = messageRepo.findAll();
        model.addAttribute("messages", messageRepoAll);
        return "main";
    }
}
