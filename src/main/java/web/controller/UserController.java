package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("listUser", userService.listUsers());
        return "/users";
    }

    @GetMapping("/user-create")
    public String createUserIndex(@ModelAttribute("listUser") User user) {

        return "/create";
    }

    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("listUser") User user) {

        userService.addUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserIndex(@PathVariable("id") Long id, Model model) {
        model.addAttribute("listUser", userService.getUserById(id));
        return "/update";
    }

    @PutMapping("/user-update")
    public String updateUser(@ModelAttribute("listUser") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

}
