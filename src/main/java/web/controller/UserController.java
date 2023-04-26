package web.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public String indexPage(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("users", userService.getUserById(id));
        return "users/index";
    }

    @GetMapping("/create")
    public String newUserPage(@ModelAttribute("user") User user) {
        return "users/create";
    }

    @PostMapping()
    public String newUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/create";
        }
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUserPage(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String editUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/users/edit";
        }
        userService.editUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}
