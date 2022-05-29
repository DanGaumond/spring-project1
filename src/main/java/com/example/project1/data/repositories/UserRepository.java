package com.example.project1.data.repositories;

import com.example.project1.data.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
