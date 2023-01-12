package com.example.peerexchange.Repositories;


import com.example.peerexchange.Models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
