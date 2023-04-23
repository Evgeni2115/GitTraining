package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
public class UserController {

    private final UserService userservice;

    @Autowired
    public UserController(UserService userservice) {
        this.userservice = userservice;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", userservice.getAllUsers());
        return "users";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }

    @PostMapping("/input")
    public String inputUser(@ModelAttribute("user") User user) {
        userservice.addUser(user);
        return "redirect:users";
    }

    @GetMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("updateable_user", userservice.getUser(id));
        return "update";
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable("id") Long id) {
        userservice.removeUser(id);
        return "redirect:users";
    }

}
