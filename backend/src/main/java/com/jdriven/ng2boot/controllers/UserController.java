package com.jdriven.ng2boot.controllers;

import com.jdriven.ng2boot.entity.User;

import com.jdriven.ng2boot.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<Long> createUser(@RequestBody User user) {

        Long id = userService.createUser(user);

        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public List<User> showAllCustomers() {
        return userService.showAllUsers();
    }

    @GetMapping("/login/{login}/password/{password}")
    public boolean isUserLogin(@PathVariable("login") String login,
                                      @PathVariable("password") String password) {
        User user = userService.getUser(login, password);

        return user != null;
    }

}
