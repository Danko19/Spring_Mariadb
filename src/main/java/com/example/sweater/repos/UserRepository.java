package com.example.sweater.repos;

import com.example.sweater.domain.spring.spring.User;
import org.springframework.data.repository.CrudRepository;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByName(String name);
}
