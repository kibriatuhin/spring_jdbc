package com.example.springjdbc.dao;

import com.example.springjdbc.entities.Student;

import java.util.List;

public interface StudentDAO {
    int insert(Student student);
    int update(Student student);
    int delete(int studentId);
    Student getStudent(int id);
    List<Student> getAllStudent();
}
