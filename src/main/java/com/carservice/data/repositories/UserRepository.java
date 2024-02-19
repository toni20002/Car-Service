package com.carservice.data.repositories;

import com.carservice.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername(String username);

    List<User> findAll();

//    Optional<User> findById(Long id);
}
