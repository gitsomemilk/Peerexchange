package com.example.peerexchange.Services;

import com.example.peerexchange.Dtos.Input.StudentDtoInput;
import com.example.peerexchange.Dtos.StudentDto;
import com.example.peerexchange.Exeptions.RecordNotFoundException;
import com.example.peerexchange.Models.Student;
import com.example.peerexchange.Repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class StudentService {
    // import van de repository in de service in plaats van in de controller
    private final StudentRepository repos;

    // constructor injection BEST PRACTICE!!!!!!
    public StudentService(StudentRepository repos) {
        this.repos = repos;
    }

    // alle studenten ophalen
    public List<StudentDto> getAllStudents(){

        List<Student> studentList = repos.findAll();
        List<StudentDto> studentListDto = new ArrayList<>();

        for (Student st : studentList){
            StudentDto dto = transferToDto(st);
            studentListDto.add(dto);
        }
        return studentListDto;
    }
    // een student ophalen door middel van id
    public StudentDto getStudentById(Long id){
        Optional<Student> studentOptional = repos.findById(id);
        if (studentOptional.isPresent()) {
            Student st = studentOptional.get();
            return transferToDto(st);
        } else {
            throw new RecordNotFoundException("geen student gevonden met dat ID nummer");
        }
    }
     // een student aanmaken met de inputDto van student
    public StudentDto addStudent(StudentDtoInput dto) {
        Student st = transferToStudent(dto);
        repos.save(st);

        return  transferToDto(st);
    }

    // een student deleten
    public void deleteStudent(@RequestBody Long id){

        repos.deleteById(id);
    }


    // vertaal methode van studentDto naar student
    public Student transferToStudent(StudentDtoInput dto){

        var student = new Student();

        student.setId(dto.getId());
        student.setFirstname(dto.getFirstname());
        student.setLastname(dto.getLastname());
        student.setUsername(dto.getUsername());
        student.setPassword(dto.getPassword());
        student.setMyClass(dto.getMyClass());

        return student;
    }

    // vertaal methode van Student naar StudentDto
    public StudentDto transferToDto(Student st){
        StudentDto dto = new StudentDto();

        dto.setId(st.getId());
        dto.setFirstname(st.getFirstname());
        dto.setLastname(st.getLastname());
        dto.setUsername(st.getUsername());
        dto.setPassword(st.getPassword());
        dto.setMyClass(st.getMyClass());

        return dto;
    }
}
