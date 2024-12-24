CREATE TABLE IF NOT EXISTS student(
    student_id SERIAL PRIMARY KEY,
    firstName VARCHAR(50),
    lastName VARCHAR(50),
    studentNumber VARCHAR(50),
    userName VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS courses(
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(50),
    student_id INTEGER REFERENCES student(student_id)
);

CREATE TABLE IF NOT EXISTS course_student(
    course_id INTEGER,
    student_id INTEGER,
    PRIMARY KEY (course_id, student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id),
    FOREIGN KEY (student_id) REFERENCES student(student_id)
);