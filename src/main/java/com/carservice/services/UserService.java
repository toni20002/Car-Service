package com.carservice.services;

import com.carservice.data.entities.Role;
import com.carservice.data.entities.User;
import com.carservice.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

    public List<User> getAllEmployees() {
        Role role = new Role();
        List<User> allUsers = this.userRepository.findAll();
        allUsers.removeIf(user -> !user.getRole_id().getAuthority().equals("EMPLOYEE"));
        return allUsers;
    }

    public Optional<User> getUserById(Long user_id) {
        return this.userRepository.findById(user_id);
    }


}
