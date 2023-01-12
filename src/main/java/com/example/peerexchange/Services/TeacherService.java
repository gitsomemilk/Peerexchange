package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.Input.TeacherDtoInput;
import com.example.peerexchange.Dtos.TeacherDto;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import com.example.peerexchange.Models.Teacher;
import com.example.peerexchange.Repositories.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    // import van de repository in de service in plaats van in de controller
    private final TeacherRepository repos;

    // constructor injection BEST PRACTICE!!!!!!
    public TeacherService(TeacherRepository repos) {
        this.repos = repos;
    }

    // alle teachers ophalen
    public List<TeacherDto> getAllTeachers(){

        List<Teacher> teacherList = repos.findAll();
        List<TeacherDto> teacherDtoList = new ArrayList<>();

        for (Teacher t : teacherList) {
            TeacherDto dto = transferToDto(t);
            teacherDtoList.add(dto);
        }
        return teacherDtoList;
    }
    // een specifieke teacher ophalen doormiddel van een id
    public TeacherDto getTeacherById(Long id){
        Optional<Teacher> teacherOptional = repos.findById(id);
        if (teacherOptional.isPresent()) {
            Teacher t = teacherOptional.get();
            return transferToDto(t);
        }else {
            throw new RecordNotFoundException("geen opdracht gevonden met dat ID nummer");

        }
    }

    // een Teacher aanmaken met de inputDto van Teacher
    public TeacherDto addTeacher(TeacherDtoInput dto){
        Teacher t = transferToTeacher(dto);
        repos.save(t);

        return transferToDto(t);
    }

    // een teacher deleten
    public void deleteTeacher(@RequestBody Long id){

        repos.deleteById(id);
    }

    // vertaal methode van TeacherDto naar Teacher
    public Teacher transferToTeacher(TeacherDtoInput dto){

        var teacher = new Teacher();

        teacher.setId(dto.getId());
        teacher.setFirstname(dto.getFirstname());
        teacher.setLastname(dto.getLastname());
        teacher.setUsername(dto.getUsername());
        teacher.setPassword(dto.getPassword());
        teacher.setToken(dto.getToken());

        return  teacher;
    }

    // vertaal methode van Teacher naar TeacherDto

    public TeacherDto transferToDto(Teacher t){
        TeacherDto dto = new TeacherDto();

        dto.setId(t.getId());
        dto.setFirstname(t.getFirstname());
        dto.setLastname(t.getLastname());
        dto.setUsername(t.getUsername());
        dto.setPassword(t.getPassword());
        dto.setToken(t.getToken());

        return dto;
    }
}
