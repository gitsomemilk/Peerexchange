package com.example.peerexchange.Controllers;

import com.example.peerexchange.Dtos.ClassDto;
import com.example.peerexchange.Dtos.Input.ClassDtoInput;
import com.example.peerexchange.Models.Assignment;
import com.example.peerexchange.Models.User;
import com.example.peerexchange.Services.ClassService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassController {

    // import ClassService
    private final ClassService classService;

    // constructor injection
    public ClassController(ClassService classService) {
        this.classService = classService;
    }


    ///---------------Mapping Blok--------------------\\\\\\\

    // ophalen van alle klassen
    @GetMapping("/all")
    public ResponseEntity<List<ClassDto>> getAllClasses() {
        List<ClassDto> dtos;
        dtos = classService.getAllClasses();

        return ResponseEntity.ok().body(dtos);
    }

    // ophalen van een Class op basis van id
    @GetMapping("/{id}")
    public ResponseEntity<ClassDto> getClassById(@PathVariable("id") Long id) {

        ClassDto classdto = classService.getClassById(id);

        return ResponseEntity.ok().body(classdto);
    }

    // het aanmaken van een class door middel van de InputDto
    @PostMapping("")
    public ResponseEntity<ClassDto> addClass(@RequestBody ClassDtoInput classDtoInput) {

        ClassDto dto = classService.addClass(classDtoInput);

        return ResponseEntity.created(null).body(dto);
    }

    // het plaatsen van een assignment in een klas
    @PostMapping("/{id}/assignment")
    public ResponseEntity<Class> addAssignmentToClass(@PathVariable Long id, @RequestBody Assignment assignmentId) {
       Class class_ = classService.addAssignmentToClass(id, assignmentId).getClass();
        return ResponseEntity.ok(class_);
    }

    // het plaatsen van een student in een klas
    @PostMapping("/{id}/student")
    public ResponseEntity<Class> addStudentToClass(@PathVariable Long id, @RequestBody User student ) {
        Class class_ = classService.addStudentToClass(id, student).getClass();
        return ResponseEntity.ok(class_);
    }

    // het plaatsen van een teacher in een klas
    @PostMapping("/{id}/{username}")
    public  ResponseEntity<String> addTeacherToClass(@PathVariable Long id, @PathVariable String username) {
      classService.addTeacherToClass(id, username);
        return new ResponseEntity<>("Leraar is toegevoegd aan een klas",HttpStatus.OK);
    }

    // het deleten van een klas
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClass(@PathVariable Long id) {

        classService.deleteClass(id);

        return ResponseEntity.noContent().build();
    }
}
