package model;

public class Courses {
    private Integer course_id;
    private String course_name;
    private Integer student_id;

    public Courses(Integer course_id, String course_name, Integer student_id) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.student_id = student_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }
}
