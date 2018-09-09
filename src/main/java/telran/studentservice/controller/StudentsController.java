package telran.studentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import telran.studentservice.dto.ScoreDto;
import telran.studentservice.dto.StudentDto;
import telran.studentservice.dto.StudentEditDto;
import telran.studentservice.dto.StudentResponseDto;
import telran.studentservice.entity.Student;
import telran.studentservice.service.IStudentService;

import java.util.List;
import java.util.Map;

@RestController
public class StudentsController {

    @Autowired
    private IStudentService studentService;

    private final static String URI = "/student";


    @GetMapping
    public Map<Integer,Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @PostMapping(URI)
    public boolean addStudent(@RequestBody StudentDto student) {
        return studentService.addStudent(student);
    }

    @DeleteMapping(URI + "/{id}")
    public StudentResponseDto deleteStudent(@PathVariable("id") int id) {
        return studentService.deleteStudent(id);
    }

    @PutMapping(URI + "/{id}")
    public StudentDto editStudent(@PathVariable("id") int id, @RequestBody StudentEditDto student) {
        return studentService.editStudent(id, student);
    }

    @GetMapping(URI + "/{id}")
    public StudentResponseDto getStudent(@PathVariable("id") int id) {
        return studentService.getStudent(id);
    }

    @PutMapping("teacher/{id}")
    public boolean addScore(@PathVariable("id") int id, @RequestBody ScoreDto score) {
        return studentService.addScore(id, score);
    }

}
