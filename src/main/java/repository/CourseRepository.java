package repository;

import connection.JdbcConnection;
import model.Courses;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseRepository {
    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public CourseRepository() throws SQLException {
    }

    public int save(Courses courses) throws SQLException {
        String add = "INSERT INTO student(course_name, student_id) VALUES(?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1, courses.getCourse_name());
        preparedStatement.setInt(2,courses.getStudent_id());
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
