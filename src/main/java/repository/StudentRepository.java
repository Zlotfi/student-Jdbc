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

    public int updateFirstName(String firstName, int student_id) throws SQLException {
        String query = "UPDATE student SET firstName = ? WHERE student_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, firstName);
        preparedStatement.setInt(2, student_id);
        int result = preparedStatement.executeUpdate();
        return result;
    }

    public int delete(int student_id) throws SQLException {
        String query = "DELETE FROM student WHERE student_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1,student_id);
        int result = preparedStatement.executeUpdate();
        return result;
    }
}
