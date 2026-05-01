// studentcrud/src/main/java/com/college/studentcrud/repository/StudentRepository.java
package com.college.studentcrud.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.college.studentcrud.model.Student;

@Repository 
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByCourse(String course);
    List<Student> findByNameContaining(String keyword);
    Optional<Student> findByEmail(String email);
    List<Student> findByCourseOrderByName(String course);
}


