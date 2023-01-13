package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.AssignmentDto;
import com.example.peerexchange.Dtos.Input.AssignmentDtoInput;
import com.example.peerexchange.Dtos.Input.RoleDtoInput;
import com.example.peerexchange.Dtos.RoleDto;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import com.example.peerexchange.Models.Assignment;
import com.example.peerexchange.Models.Role;
import com.example.peerexchange.Repositories.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class RoleService {
    // import van de repository in de service in plaats van in de controller
    private final RoleRepository repos;

    // constructor injection BEST PRACTICE!!!!!!
    public RoleService(RoleRepository repos) {
        this.repos = repos;
    }

    // alle rolen ophalen
    public List<RoleDto> getAllRoles() {
        List<Role> roleList = repos.findAll();
        List<RoleDto> roleDtoList = new ArrayList<>();

        for (Role r : roleList){
            RoleDto dto = transferToDto(r);
            roleDtoList.add(dto);
        }
        return roleDtoList;
    }

    // specifieke role ophalen doormiddel van id ->(string rolename)
    public RoleDto getRoleById(String id){
        Optional<Role> roleOptional = repos.findById(id);
        if (roleOptional.isPresent()) {
            Role r = roleOptional.get();
            return transferToDto(r);
        }else{
            throw new RecordNotFoundException("geen role gevonden met die naam");
        }
    }

    // een role aanmaken door middel van de input dto
    public RoleDto addRole(RoleDtoInput dto){
        Role r = transferToRole(dto);
        repos.save(r);

        return transferToDto(r);
    }

    // deleten van een role
    public void deleteRole(@RequestBody String id){

        repos.deleteById(id);

    }

    // vertaal methode van RoleDto naar Role
    public Role transferToRole(RoleDtoInput dto){

        var role = new Role();

        role.setRolename(dto.getRolename());
        role.setUsers(dto.getUsers());

        return role;
    }

    // vertaal methode van Role naar RoleDto
    public RoleDto transferToDto( Role r){

        RoleDto dto = new RoleDto();

        dto.setRolename(r.getRolename());
        dto.setUsers(r.getUsers());

        return dto;
    }


}
