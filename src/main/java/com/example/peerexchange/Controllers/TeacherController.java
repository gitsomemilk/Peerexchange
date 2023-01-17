package com.example.peerexchange.Controllers;

import com.example.peerexchange.Dtos.Input.ReviewDtoInput;
import com.example.peerexchange.Dtos.Input.TeacherDtoInput;
import com.example.peerexchange.Dtos.ReviewDto;
import com.example.peerexchange.Dtos.TeacherDto;
import com.example.peerexchange.Services.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    ///---------------Mapping Blok--------------------\\\\\\\

    // ophalen van alle reviews
    @GetMapping("/all")
    public ResponseEntity<List<TeacherDto>> getAllTeachers(){
        List<TeacherDto> dtos;
        dtos = teacherService.getAllTeachers();

        return ResponseEntity.ok().body(dtos);
    }
    // ophalen van een review op basis van id
    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getTeacherById(@PathVariable("id") Long id) {

        TeacherDto teacher = teacherService.getTeacherById(id);

        return ResponseEntity.ok().body(teacher);
    }

    // het plaatsen van een review door middel van de inputDto Review
    @PostMapping("")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDtoInput teacherDtoInput ){

        TeacherDto dto = teacherService.addTeacher(teacherDtoInput);

        return ResponseEntity.created(null).body(dto);
    }
    // verwijderen van een review door middel van id
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTeacher(@PathVariable Long id) {

        teacherService.deleteTeacher(id);

        return ResponseEntity.noContent().build();
    }
}
