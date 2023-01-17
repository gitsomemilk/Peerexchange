package com.example.peerexchange.Controllers;


import com.example.peerexchange.Dtos.Input.StudentDtoInput;
import com.example.peerexchange.Dtos.StudentDto;
import com.example.peerexchange.Models.Student;
import com.example.peerexchange.Services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    // import van de StudentService
    private final StudentService studentService;

    // constructor injection best practice

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    ///---------------Mapping Blok--------------------\\\\\\\

    // alle studenten ophalen
    @GetMapping("/all")
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> dtos;
        dtos = studentService.getAllStudents();

        return ResponseEntity.ok().body(dtos);
    }

    // ophalen van een student op basis van id
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {

        StudentDto student = studentService.getStudentById(id);

        return ResponseEntity.ok().body(student);
    }


    // het maken van een student door middel van de inputDto Student
    @PostMapping("")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDtoInput studentDtoInput) {

        StudentDto dto = studentService.addStudent(studentDtoInput);

        return ResponseEntity.created(null).body(dto);
    }

    // verwijderen van een Student door middel van id
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

}



