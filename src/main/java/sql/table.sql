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