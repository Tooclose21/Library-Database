package com.example.technologiesieciowe.repository;

import com.example.technologiesieciowe.entity.Book;
import com.example.technologiesieciowe.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String userName);
}
