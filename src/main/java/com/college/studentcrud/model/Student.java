// studentcrud/src/main/java/com/college/studentcrud/model/Student.java
package com.college.studentcrud.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, unique = true, nullable = false)
    private String name;

    @Column(length = 100, unique = true, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String course;

    @Column(length = 15, unique = true)
    private String phone;

    public Student() {}

    public Student(String name, String email, String course, String phone) {
        this.name = name;
        this.email = email;
        this.course = course;
        this.phone = phone;
    }

    // Getter methods
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public String getPhone() { return phone; }

    // Setter methods
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setCourse(String course) { this.course = course; }
    public void setPhone(String phone) { this.phone = phone; }
}