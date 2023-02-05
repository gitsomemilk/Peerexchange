package com.example.peerexchange.Repositories;


import com.example.peerexchange.Models.Submission;
import com.example.peerexchange.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

}
