package com.example.peerexchange.Controllers;

import com.example.peerexchange.Dtos.ClassDto;
import com.example.peerexchange.Dtos.Input.ClassDtoInput;
import com.example.peerexchange.Services.ClassService;
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
    public ResponseEntity<List<ClassDto>> getAllClasses(){
        List<ClassDto> dtos;
        dtos = classService.getAllClasses();

        return ResponseEntity.ok().body(dtos);
    }

    // ophalen van een Class op basis van id
    @GetMapping("/{id}")
    public ResponseEntity<ClassDto> getClassById(@PathVariable ( "id" ) Long id) {

        ClassDto classdto = classService.getClassById(id);

        return ResponseEntity.ok().body(classdto);
    }

    // het aanmaken van een class door middel van de InputDto
    @PostMapping("")
    public ResponseEntity<ClassDto> addClass(@RequestBody ClassDtoInput classDtoInput) {

        ClassDto dto = classService.addClass(classDtoInput);

        return ResponseEntity.created(null).body(dto);
    }

    // het deleten van een class
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteClass(@PathVariable Long id){

        classService.deleteClass(id);

        return ResponseEntity.noContent().build();
    }
}
