package com.iamzexy.SpringTestTask.controllers;

import com.iamzexy.SpringTestTask.models.User;
import com.iamzexy.SpringTestTask.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Demin Artem
 */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/users")
    public List<User> getUsers() {
        return userService.getAll();
    }

    @GetMapping(path = "/users/{login}")
    public List<User> getUserByLogin(@PathVariable("login") String login) {
        return List.of(userService.getByLogin(login));
    }

    @PostMapping(path = "/users/add")
    public void addClient(@RequestBody User user) {
        userService.addClient(user);
    }

    @PutMapping(path = "/users/{login}")
    public void updateClient(
            @RequestBody User user
    ) {
        userService.updateClient(user);
    }

    @DeleteMapping(path = "/users/{login}")
    public void deleteClient(@PathVariable String login) {
        userService.deleteClient(login);
    }

}
