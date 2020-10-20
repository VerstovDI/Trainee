package ru.greenatom.edu.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.greenatom.edu.domain.Message;
import ru.greenatom.edu.repository.MessageRepository;

import java.util.List;

@Controller
public class GreetingController {
    @Autowired
    private MessageRepository messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("something", "Hello, again!");
        Iterable<Message> messageRepoAll = messageRepo.findAll();
        model.addAttribute("messages", messageRepoAll);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Model model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);
        // Так делать не надо вообще, но для обучения норм
        Iterable<Message> messageRepoAll = messageRepo.findAll();
        model.addAttribute("messages", messageRepoAll);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Model model) {
        Iterable<Message> messagesByTag;
        if (filter != null && !filter.isEmpty()) {
            messagesByTag = messageRepo.findByTag(filter);
        } else {
            messagesByTag = messageRepo.findAll();
        }
        model.addAttribute("messages", messagesByTag);
        return "main";
    }
}
