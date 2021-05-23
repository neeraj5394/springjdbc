package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;

import java.util.List;

public interface StudentDao {
    public int insert (Student student);
    public int change(Student student);
    public int delete(Student student);
    public Student getStudent(int id);
    public List<Student> getAllStudents();
}
