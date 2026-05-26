INSERT INTO alumno (nombre, email, ciudad, edad) VALUES ('Pablo Navarro', 'pablo@gmail.com', 'Malaga', 22);
INSERT INTO alumno (nombre, email, ciudad, edad) VALUES ('Laura Martin', 'laura@gmail.com', 'Sevilla', 25);
INSERT INTO alumno (nombre, email, ciudad, edad) VALUES ('Carlos Ruiz', 'carlos@gmail.com', 'Malaga', 19);
INSERT INTO alumno (nombre, email, ciudad, edad) VALUES ('Ana Lopez', 'ana@gmail.com', 'Granada', 30);

INSERT INTO curso (nombre, categoria, horas, precio) VALUES ('Java Spring', 'Backend', 80, 250.0);
INSERT INTO curso (nombre, categoria, horas, precio) VALUES ('Flutter', 'Mobile', 60, 180.0);
INSERT INTO curso (nombre, categoria, horas, precio) VALUES ('Angular', 'Frontend', 70, 220.0);
INSERT INTO curso (nombre, categoria, horas, precio) VALUES ('MongoDB', 'Backend', 40, 120.0);

INSERT INTO matricula (fecha, nota_final, alumno_id, curso_id) VALUES ('2026-05-01', 8.5, 1, 1);
INSERT INTO matricula (fecha, nota_final, alumno_id, curso_id) VALUES ('2026-05-02', 4.2, 1, 2);
INSERT INTO matricula (fecha, nota_final, alumno_id, curso_id) VALUES ('2026-05-03', 6.7, 2, 3);
INSERT INTO matricula (fecha, nota_final, alumno_id, curso_id) VALUES ('2026-05-04', 9.1, 3, 4);
INSERT INTO matricula (fecha, nota_final, alumno_id, curso_id) VALUES ('2026-05-05', 3.8, 4, 1);