package service;

import model.Student;
import repository.StudentRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentService {

    Scanner input = new Scanner(System.in);
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

    public void login() throws SQLException {
        System.out.println("please enter your username:");
        String userName = input.nextLine();
        System.out.println("please enter your password:");
        String password = input.nextLine();

        Student student = studentRepository.login(userName);
        if ((student != null) && student.getPassword().equals(password))
            System.out.println("login successfully");
        else
            System.out.println("Bad Credentials");
    }

    public void changeFirstName() throws SQLException {
        System.out.println("please enter your new firstName:");
        String firstName = input.nextLine();
        int result = studentRepository.updateFirstName(firstName);
        if(result!= 0)
            System.out.println("successfully update to database");
        else
            System.out.println("Oops :(");
    }
}
