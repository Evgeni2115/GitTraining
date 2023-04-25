package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private UserService userservice;

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
    public String userCreationPage(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }

    @PostMapping("/input")
    public String inputUser(@ModelAttribute("user") User user) {

        userservice.createUser(user);
        return "redirect:users";
    }

    @GetMapping("/{id}/edit")
    public String displayTheEditPage(@PathVariable("id") Long id, Model model) {

        model.addAttribute("editable_user", userservice.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("editable_user") User user, @PathVariable("id") Long id) {

        userservice.updateUser(id, user);
        return "redirect:users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        userservice.removeUser(id);
        return "redirect:users";
    }


}




