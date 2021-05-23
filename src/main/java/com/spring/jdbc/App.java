package com.spring.jdbc;


import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Welcome to my app" );
        ApplicationContext context = new AnnotationConfigApplicationContext("com.spring.jdbc");
        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        //insert or update
//        student.setId("1");
//        student.setCity("Dehradun");
//        student.setName("Solanki");
//        int r = studentDao.change(student);

        //delete
//        student.setId("6");
//        int r= studentDao.delete(student);
//        System.out.println(r);

        // get Student row
//        Student student = studentDao.getStudent(1);
//        System.out.println(student);

        //get All Students
        List<Student> students = studentDao.getAllStudents();
        for(Student student: students)
        {
            System.out.println(student);
        }
    }
}
