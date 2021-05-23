package com.spring.jdbc.dao;

import com.spring.jdbc.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(Student student) {
        String query = "insert into Student values (?,?,?);";
        int r = this.jdbcTemplate.update(query, student.getId(), student.getName(), student.getCity());
        return r;
    }

    @Override
    public int change(Student student) {
        String query = "Update student set name= ?, city= ? where id = ?";
        int r = this.jdbcTemplate.update(query, student.getName(), student.getCity(), student.getId());
        return r;
    }

    @Override
    public int delete(Student student) {
        String query = "Delete from student where id= ?";
        int r= this.jdbcTemplate.update(query, student.getId());
        return r;
    }

    @Override
    public Student getStudent(int id) {
        String query = "select * from student where id  = ?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = jdbcTemplate.queryForObject(query, rowMapper, id);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        String query = "select * from student";
        List<Student> students = this.jdbcTemplate.query(query, new RowMapperImpl ());
        return students;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
