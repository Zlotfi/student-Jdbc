package service;

import model.Student;
import repository.StudentRepository;

import java.sql.SQLException;

public class StudentService {

    private final StudentRepository studentRepository = new StudentRepository();

    public StudentService() throws SQLException {
    }

    public void register() throws SQLException {
        Student student = new Student
               (null, "zahra", "lotfi", "123456789","zlotfi80","1234");
        int result = studentRepository.save(student);
        if(result!= 0)
            System.out.println(student.getFirstName() + " successfully added to database");
        else
            System.out.println("Oops :(");

    }
}
