package com.example.springjdbc;

import com.example.springjdbc.dao.StudentDaoImpl;
import com.example.springjdbc.entities.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(context.getBeanDefinitionCount());

        StudentDaoImpl studentDao = context.getBean("StudentDaoImpl",StudentDaoImpl.class);

        Student ob = new Student();
        ob.setId(105);
        ob.setName("Asikur rahman");
        ob.setCity("Gatail");

        int result = studentDao.insert(ob);

        System.out.println("insert successfully .. number of record inserted : " + result);


    }

}
