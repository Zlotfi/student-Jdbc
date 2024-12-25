package menu;

import model.Student;
import service.StudentService;
import utility.ApplicationContext;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    private final Scanner input = new Scanner(System.in);
    private final StudentService studentService = ApplicationContext.getStudentService();

    public Menu() throws SQLException {
    }

    public void publicMenu() throws SQLException {
        System.out.println("***welcome***");
        System.out.println("1- Sign In");
        System.out.println("2- Sign Up");
        System.out.println("3- Exit");
        System.out.println("Enter Your Select: ");
        int select = input.nextInt();
        input.nextLine();
        switch (select){
            case 1 -> enter();
            case 2 -> register();
            case 3 -> System.out.println("Exit");
            default -> System.out.println("error");
        }
    }

    public void register() throws SQLException {
        System.out.println("Enter your fistName: ");
        String firstName = input.nextLine();

        System.out.println("Enter your lastName: ");
        String lastName = input.nextLine();

        System.out.println("Enter your studentNumber: ");
        String studentNumber = input.nextLine();

        System.out.println("Enter your userName: ");
        String userName = input.nextLine();

        System.out.println("Enter your password: ");
        String password = input.nextLine();

        Student student = new Student(null,firstName,lastName,studentNumber,userName,password);
        studentService.register(student);
    }

    public void enter() throws SQLException {
        System.out.println("Enter your userName: ");
        String userName = input.nextLine();

        System.out.println("Enter your password: ");
        String password = input.nextLine();
        Student student = studentService.login(userName, password);

        if (student == null && !student.getPassword().equals(password))
            System.out.println("you are enter a userName and password incorrect");
        else {
            boolean isTrue = true;
            while (isTrue) {
                System.out.println("================================================");
                System.out.println("1- update firstName");
                System.out.println("2- delete yourSelf");
                System.out.println("3- Exit");
                int number = input.nextInt();
                input.nextLine();
                switch (number) {
                    case 1 -> studentService.changeFirstName(student.getStudent_id());
                    case 2 -> studentService.delete(student.getStudent_id());
                    case 3 -> isTrue = false;
                    default -> System.out.println("error");
                }
            }
        }
    }
}
