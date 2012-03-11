package com.acme.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.acme.domain.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    
    List<User> findByLastname(String lastname);
    
}
