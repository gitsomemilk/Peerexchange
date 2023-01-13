package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.AssignmentDto;
import com.example.peerexchange.Dtos.Input.AssignmentDtoInput;
import com.example.peerexchange.Dtos.Input.UserDtoInput;
import com.example.peerexchange.Dtos.UserDto;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import com.example.peerexchange.Models.Assignment;
import com.example.peerexchange.Models.User;
import com.example.peerexchange.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    // import van de repository in de service
    private final UserRepository repos;

    // constructor injection
    public UserService(UserRepository repos) {
        this.repos = repos;
    }

    // ophalen van alle users
    public List<UserDto> getAllUsers(){

        List<User> userList = repos.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User u : userList) {
            UserDto dto = transferToDto(u);
            userDtoList.add(dto);
        }
        return userDtoList;
    }
    // ophalen van een user door middel van id
    public UserDto getUserById(String id) {
        Optional<User>userOptional = repos.findById(id);

        if (userOptional.isPresent()){
            User u = userOptional.get();
            return transferToDto(u);
        }else {
            throw new RecordNotFoundException("geen user gevonden met dat ID nummer");
        }
    }

    // user aanmaken door middel van de inputDto user
    public UserDto addUser(UserDtoInput dto){
        User u = transferToUser(dto);
        repos.save(u);

        return transferToDto(u);
    }

    // deleten van een user
    public void deleteUser(@RequestBody String id) {

        repos.deleteById(id);
    }
    //vertaal methode van UserDto naar User
    public User transferToUser(UserDtoInput dto){

        var user = new User();

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRoles(dto.getRoles());


        return user;

    }

    // de vertaal methode van Assignment naar AssignmentDto
    public UserDto transferToDto(User u) {
        UserDto dto = new UserDto();

        dto.setUsername(u.getUsername());
        dto.setPassword(u.getPassword());
        dto.setRoles(u.getRoles());


        return dto;
    }

}

