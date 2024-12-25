package utility;

import connection.JdbcConnection;
import repository.StudentRepository;
import service.StudentService;

import java.sql.Connection;

public class ApplicationContext {

    private static final Connection CONNECTION;
    private static final StudentRepository STUDENT_REPOSITORY;
    private static final StudentService STUDENT_SERVICE;

    static {
        CONNECTION = JdbcConnection.getConnection();
        STUDENT_REPOSITORY = new StudentRepository(CONNECTION);
        STUDENT_SERVICE = new StudentService(STUDENT_REPOSITORY);
    }

    public static StudentService getStudentService(){
        return STUDENT_SERVICE;
    }
}
