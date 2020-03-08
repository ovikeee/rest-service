package ru.megafon.restservice.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.megafon.restservice.controller.MainController;

@Controller
public class UserViewController {
    @Autowired
    MainController mainController;

    @RequestMapping("/user")
    public String user(Model model) {
        model.addAttribute("orders", mainController.get());
        return "user";
    }

    @RequestMapping("/user-simple")
    public String userSimple(Model model) {
        model.addAttribute("orders", mainController.get());
        return "user-simple";
    }
}
