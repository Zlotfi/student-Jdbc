package service;

import model.Student;
import repository.StudentRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentService {

    Scanner input = new Scanner(System.in);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public void register(Student student) throws SQLException {
        int result = studentRepository.save(student);
        if(result!= 0)
            System.out.println(student.getFirstName() + " successfully added to database");
        else
            System.out.println("Unknown error");

    }

    public Student login(String userName, String password) throws SQLException {
        Student student = studentRepository.login(userName);
        return student;
    }

    public void changeFirstName(int student_id) throws SQLException {
        System.out.println("please enter your new firstName:");
        String firstName = input.nextLine();
        int result = studentRepository.updateFirstName(firstName, student_id);
        if(result!= 0)
            System.out.println("successfully update to database");
        else
            System.out.println("Unknown error");
    }

    public void delete(int student_id) throws SQLException {
        int result = studentRepository.delete(student_id);
        if(result!= 0)
            System.out.println("successfully deleted from database");
        else
            System.out.println("Unknown error");
    }
}
