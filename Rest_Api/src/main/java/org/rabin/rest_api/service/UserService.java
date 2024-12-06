package org.rabin.rest_api.service;


/*
 * @author : rabin
 */

import org.rabin.rest_api.entity.User;
import org.rabin.rest_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * Registers a new user by hashing the password and saving it to the database.
     *
     * @param user the user to register
     * @return the registered user
     */
    public User registerUser(User user) {
        // Hash password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * Authenticates a user by validating the username and password.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @return the authenticated user
     * @throws UsernameNotFoundException if the user is not found
     * @throws IllegalArgumentException if the password is incorrect
     */
    public User loginUser(String username, String password) {
        // Fetch user from database
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Check if the provided password matches the hashed password
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }
        return user;
    }
}