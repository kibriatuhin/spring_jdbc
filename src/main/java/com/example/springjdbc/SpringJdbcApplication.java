package com.example.springjdbc;

import com.example.springjdbc.config.AppConfig;
import com.example.springjdbc.dao.StudentDaoImpl;
import com.example.springjdbc.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBeanDefinitionCount());

        StudentDaoImpl studentDao = context.getBean("studentImpl",StudentDaoImpl.class);


        List<Student> list = studentDao.getAllStudent();
        list.forEach(System.out::println);


    }

}
