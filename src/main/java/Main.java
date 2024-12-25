import menu.Menu;
import model.Courses;
import model.Student;
import repository.CourseRepository;
import repository.StudentRepository;
import service.StudentService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
//        StudentRepository studentRepository = new StudentRepository();
//        Student student = new Student
//                (null, "zahra", "lotfi", "123456789","zlotfi80","1234");
//        studentRepository.save(student);
//        CourseRepository courseRepository = new CourseRepository();
//        Courses courses = new Courses(null,"riazi",1);
//        courseRepository.save(courses);
//        StudentService studentService = new StudentService();
//        studentService.register();
//        studentService.login();
//        studentService.changeFirstName();

//        studentService.delete();

        Menu menu = new Menu();
        menu.publicMenu();
    }
}
