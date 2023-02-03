package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.ClassDto;
import com.example.peerexchange.Dtos.Input.ClassDtoInput;
import com.example.peerexchange.Models.Assignment;
import com.example.peerexchange.Models.User;
import com.example.peerexchange.Repositories.AssignmentRepository;
import com.example.peerexchange.Repositories.ClassRepository;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import com.example.peerexchange.Repositories.UserRepository;
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
    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;


    // constructor injection BEST PRACTICE!!!!!!
    public ClassService(ClassRepository repos, AssignmentRepository assignmentRepository, UserRepository userRepository) {
        this.repos = repos;
        this.assignmentRepository = assignmentRepository;
        this.userRepository = userRepository;
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

    // een Assignment toevoegen aan een Class class
    public Class addAssignmentToClass(Long id, Assignment assignmentId){
       Optional<Class> optionalClass = repos.findById(id);
       if (optionalClass.isPresent()) {
           Class class_ = optionalClass.get();
           List<Assignment> assignments = class_.getAssignments();
           assignments.add(assignmentId);
           class_.setAssignments(assignments);
           assignmentId.setClass(class_);
           assignmentRepository.save(assignmentId);
           repos.save(class_);

           return repos.save(class_);
       } else {
           throw new RecordNotFoundException();
       }
    }

    // een Student User toevoegen aan een Class
    public Class addStudentToClass(Long id, User student){
        Optional<Class> optionalClass = repos.findById(id);
        if (optionalClass.isPresent()){
            Class class_ = optionalClass.get();
            student.setClass(class_);
            userRepository.save(student);
            class_.getStudents().add(student);
            return repos.save(class_);

        } else {
            throw new RecordNotFoundException();
        }
    }

    // een Teacher User toevoegen aan een klass
    public void addTeacherToClass(Long classId, String teacherId) {
        Optional<Class> classOptional = repos.findById(classId);
        Optional<User> userOptional = userRepository.findById(teacherId);

        if (classOptional.isPresent() && userOptional.isPresent()){
            Class class_ = classOptional.get();
            User teacher = userOptional.get();

            class_.setTeacher(teacher);
            repos.save(class_);
        }
    }

    // vertaal methode van ClassDto naar Class
    public Class transferToClass(ClassDtoInput dto) {
        var class_ = new Class();

        class_.setId(dto.getId());
        class_.setName(dto.getName());
        class_.setTeacher(dto.getTeacher());
        class_.setStudents(dto.getStudents());
        class_.setAssignments(dto.getAssignments());



        return class_;

    }


    // vertaal methode van Class naar Classdto
    public ClassDto transferToDto(Class cl) {
        ClassDto dto = new ClassDto();

        dto.setId(cl.getId());
        dto.setName(cl.getName());
        dto.setTeacher(cl.getTeacher());
        dto.setStudents(cl.getStudents());
        dto.setAssignments(cl.getAssignments());

        return dto;
    }
}


