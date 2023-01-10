package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.ClassDto;
import com.example.peerexchange.Dtos.Input.ClassDtoInput;
import com.example.peerexchange.Repositories.ClassRepository;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.peerexchange.Models.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    // import van de repository in de service in plaats van in de controller
    private final ClassRepository repos;

    // constructor injection BEST PRACTICE!!!!!!
    public ClassService(ClassRepository repos) {
        this.repos = repos;
    }

    // alle classen ophalen
    public List<ClassDto> getAllClasses() {

        List<Class> classList = repos.findAll();
        List<ClassDto> classListDto = new ArrayList<>();

        for (Class cl : classList) {
            ClassDto dto = transferToDto(cl);
            classListDto.add(dto);
        }
        return classListDto;


    }

    // een class ophalen op hun id
    public ClassDto getClassById(Long id) {
        Optional<Class> classOptional = repos.findById(id);
        if (classOptional.isPresent()) {
            Class cl = classOptional.get();
            return transferToDto(cl);
        } else {
            throw new RecordNotFoundException("geen klas gevonden met dat ID nummer");
        }

    }
    // een class aanmaken met de inputDTO van class
    public ClassDto addClass(ClassDtoInput dto){

        Class cl = transferToClass(dto);
        repos.save(cl);

        return transferToDto(cl);

    }

    // een class verwijderen
    public void deleteClass(@RequestBody Long id){

        repos.deleteById(id);
    }

    // vertaal methode van ClassDto naar Class
    public Class transferToClass(ClassDtoInput dto) {
        var class_ = new Class();

        class_.setId(dto.getId());
        class_.setName(dto.getName());
        class_.setTeacher_id(dto.getTeacher_id());

        return class_;

    }


    // vertaal methode van Class naar Classdto
    public ClassDto transferToDto(Class cl) {
        ClassDto dto = new ClassDto();

        dto.setId(cl.getId());
        dto.setName(cl.getName());
        dto.setTeacher_id(cl.getTeacher_id());

        return dto;
    }
}


