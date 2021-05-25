package com.example.demo.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/student")
    public List getStudents(){
        return studentService.getStudents();
    }

    @PostMapping("/student")
    public String addNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
        return "New student created";
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable long id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/student/{id}")
    public void updateStudent(@PathVariable long id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentService.updateStudent(id, name, email);
    }
}
