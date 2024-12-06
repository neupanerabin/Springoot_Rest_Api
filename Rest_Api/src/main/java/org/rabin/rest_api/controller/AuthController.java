package org.rabin.rest_api.controller;


/*
 * @author : rabin
 */
import org.rabin.rest_api.entity.User;
import org.rabin.rest_api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

//    public ResponseEntity<User> register(@RequestBody User user) {
//        return ResponseEntity.ok(authService.register(user));
//    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User authenticatedUser = authService.login(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(401).body(null); // Unauthorized if login fails
        }
    }

}