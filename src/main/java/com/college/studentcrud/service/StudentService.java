// studentcrud/src/main/java/com/college/studentcrud/service/StudentService.java
package com.college.studentcrud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.college.studentcrud.model.Student;
import com.college.studentcrud.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(int id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudentByCourse(String course) {
        return studentRepository.findByCourse(course);
    }

    public List<Student> searchByName(String keyword) {
        return studentRepository.findByNameContaining(keyword);
    }

    public Optional<Student> updateStudent(int id, Student updatedData) {
        Optional<Student> existingOpt = studentRepository.findById(id);

        if (existingOpt.isPresent()) {
            Student existing = existingOpt.get();

            existing.setName(updatedData.getName());
            existing.setEmail(updatedData.getEmail());
            existing.setCourse(updatedData.getCourse());
            existing.setPhone(updatedData.getPhone());

            Student saved = studentRepository.save(existing);
            return Optional.of(saved);
        }
        return Optional.empty();
    }

    public boolean deleteStudent(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public long getTotalCount() {
        return studentRepository.count();
    }

}