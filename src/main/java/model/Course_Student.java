package model;

public class Course_Student {
    private Integer course_id;
    private Integer student_id;

    public Course_Student(Integer course_id, Integer student_id) {
        this.course_id = course_id;
        this.student_id = student_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
}
