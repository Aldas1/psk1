-- Sukuriamos lentelės
CREATE TABLE faculties (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE students (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    faculty_id INT REFERENCES faculties(id)
);

CREATE TABLE courses (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    credits INT NOT NULL,
    faculty_id INT REFERENCES faculties(id)
);

-- Many-to-many ryšys tarp students ir courses lentelių
CREATE TABLE student_courses (
    student_id INT REFERENCES students(id),
    course_id INT REFERENCES courses(id),
    registration_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (student_id, course_id)
);

-- Indeksai
CREATE INDEX idx_students_faculty ON students(faculty_id);
CREATE INDEX idx_courses_faculty ON courses(faculty_id);
CREATE INDEX idx_student_courses_student ON student_courses(student_id);
CREATE INDEX idx_student_courses_course ON student_courses(course_id);