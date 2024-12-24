package repository;

import connection.JdbcConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
