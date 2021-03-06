package com.example.s26.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.s26.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
