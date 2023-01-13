package com.example.peerexchange.Repositories;


import com.example.peerexchange.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, String> {
}
