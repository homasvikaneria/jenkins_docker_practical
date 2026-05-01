// studentcrud/src/main/java/com/college/studentcrud/controller/StudentController.java
package com.college.studentcrud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.college.studentcrud.model.Student;
import com.college.studentcrud.service.StudentService;

@RestController
@RequestMapping("/api/students")

public class StudentController {
    private final StudentService studentService;

    @Autowired

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get all Students
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Optional<Student> student = studentService.getStudentById(id);

        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> getStudentByCourse(@RequestParam String course) {

        List<Student> students = studentService.getStudentByCourse(course);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<List<Student>> searchByName(@RequestParam String name) {

        List<Student> students = studentService.searchByName(name);
        return ResponseEntity.ok(students);
    }

    @GetMapping("/count")
    public ResponseEntity<String> getCount() {

        long count = studentService.getTotalCount();
        return ResponseEntity.ok("Total Student in database: " + count);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student saved = studentService.addStudent(student);
        return ResponseEntity.status(201).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedData) {

        Optional<Student> result = studentService.updateStudent(id, updatedData);

        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        boolean deleted = studentService.deleteStudent(id);

        if (deleted) {
            return ResponseEntity.ok("Student deleted successfully of id "+id+".");
        }

        return ResponseEntity.notFound().build();
    }

}
