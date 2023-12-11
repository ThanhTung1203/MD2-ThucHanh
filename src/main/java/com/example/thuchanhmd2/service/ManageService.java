package com.example.thuchanhmd2.service;

import com.example.thuchanhmd2.model.Student;

import java.util.List;

public interface ManageService {
    Student findById(int id);
    void delete(int id);


    void update(int id, Student student);
    void save(Student student);
    List<Student> showALl();
}
