package repository;

import connection.JdbcConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRepository {

    JdbcConnection jdbcConnection = new JdbcConnection();
    Connection connection = jdbcConnection.getConnection();

    public StudentRepository() throws SQLException {
    }

    public int save(Student student) throws SQLException {
        String add = "INSERT INTO student(firstName, lastName, studentNumber, userName, password) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(add);
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, student.getStudentNumber());
        preparedStatement.setString(4, student.getUserName());
        preparedStatement.setString(5, student.getPassword());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public Student login(String userName) throws SQLException {
        String loginQuery ="SELECT * FROM student WHERE userName = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(loginQuery);
        preparedStatement.setString(1,userName);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            Student student = new Student(
                    resultSet.getInt("student_id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("lastName"),
                    resultSet.getString("studentNumber"),
                    resultSet.getString("userName"),
                    resultSet.getString("password")

            );
            return student;
        }
        else
            return null;
    }
}
