package com.example.peerexchange.Services;

import com.example.peerexchange.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // import van de repository in de service
    private final UserRepository repos;

    // constructor injection
    public UserService(UserRepository repos) {
        this.repos = repos;
    }

    // ophalen van alle users

}
