package com.example.springjdbc.dao;

import com.example.springjdbc.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("studentImpl")
public class StudentDaoImpl implements StudentDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insert(Student student) {
        String query = "insert into student values (? , ? , ?)";

        //fire query
        int result =  jdbcTemplate.update(query,student.getId(),student.getName() , student.getCity());
        return result;
    }

    @Override
    public int update(Student student) {
        String query = "update student set name=? , city=? where id = ?";

        //fire query
        int result =  jdbcTemplate.update(query,student.getName(),student.getCity(),student.getId());
        return result;
    }

    @Override
    public int delete(int studentId) {
        String query = "delete from student where id=?";
        int result = jdbcTemplate.update(query,studentId);
        return result;
    }

    @Override
    public Student getStudent(int id) {
        String query = "select * from student where id =?";
        RowMapper<Student> rowMapper = new RowMapperImpl();
        Student student = this.jdbcTemplate.queryForObject(query,rowMapper,id);
        return student;
    }

    @Override
    public List<Student> getAllStudent() {
        String query = "select * from student";
        List<Student> student = this.jdbcTemplate.query(query,new RowMapperImpl());
        return student;
    }


}
