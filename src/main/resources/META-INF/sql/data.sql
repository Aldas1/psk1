-- Įkeliami fakultetai
INSERT INTO faculties (name) VALUES
('Matematikos ir informatikos fakultetas'),
('Ekonomikos fakultetas'),
('Fizikos fakultetas');

-- Įkeliami kursai
INSERT INTO courses (title, description, credits, faculty_id) VALUES
('Java programavimas', 'Pagrindiniai Java programavimo principai ir praktika', 6, 1),
('Duomenų bazių sistemos', 'SQL ir duomenų bazių projektavimas', 5, 1),
('Algoritmai ir duomenų struktūros', 'Pagrindiniai algoritmai ir duomenų struktūros', 6, 1),
('Mikroekonomika', 'Mikroekonomikos teorija ir principai', 4, 2),
('Makroekonomika', 'Makroekonomikos teorija ir modeliai', 4, 2),
('Kvantinė fizika', 'Kvantinės fizikos pagrindai', 7, 3);

-- Įkeliami studentai
INSERT INTO students (first_name, last_name, email, faculty_id) VALUES
('Jonas', 'Jonaitis', 'jonas.jonaitis@stud.example.com', 1),
('Petras', 'Petraitis', 'petras.petraitis@stud.example.com', 1),
('Ona', 'Onaitė', 'ona.onaite@stud.example.com', 2),
('Rasa', 'Rasaitė', 'rasa.rasaite@stud.example.com', 3),
('Tomas', 'Tomaitis', 'tomas.tomaitis@stud.example.com', 1);

-- Studentų registracija į kursus
INSERT INTO student_courses (student_id, course_id) VALUES
(1, 1), -- Jonas -> Java programavimas
(1, 2), -- Jonas -> Duomenų bazių sistemos
(2, 1), -- Petras -> Java programavimas
(2, 3), -- Petras -> Algoritmai ir duomenų struktūros
(3, 4), -- Ona -> Mikroekonomika
(3, 5), -- Ona -> Makroekonomika
(4, 6), -- Rasa -> Kvantinė fizika
(5, 1), -- Tomas -> Java programavimas
(5, 2), -- Tomas -> Duomenų bazių sistemos
(5, 3); -- Tomas -> Algoritmai ir duomenų struktūros