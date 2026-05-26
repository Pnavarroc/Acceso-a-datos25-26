INSERT INTO socio (nombre, email, ciudad, edad) VALUES ('Pablo Navarro', 'pablo@gmail.com', 'Malaga', 22);
INSERT INTO socio (nombre, email, ciudad, edad) VALUES ('Laura Martin', 'laura@gmail.com', 'Sevilla', 25);
INSERT INTO socio (nombre, email, ciudad, edad) VALUES ('Carlos Ruiz', 'carlos@gmail.com', 'Malaga', 19);
INSERT INTO socio (nombre, email, ciudad, edad) VALUES ('Ana Lopez', 'ana@gmail.com', 'Granada', 30);

INSERT INTO libro (titulo, autor, genero, paginas, precio) VALUES ('El codigo limpio', 'Robert Martin', 'Programacion', 450, 39.99);
INSERT INTO libro (titulo, autor, genero, paginas, precio) VALUES ('Java Basico', 'Ana Lopez', 'Programacion', 300, 24.99);
INSERT INTO libro (titulo, autor, genero, paginas, precio) VALUES ('Mongo para todos', 'Carlos Ruiz', 'Bases de datos', 220, 19.99);
INSERT INTO libro (titulo, autor, genero, paginas, precio) VALUES ('Spring Boot Pro', 'Laura Perez', 'Programacion', 520, 44.99);
INSERT INTO libro (titulo, autor, genero, paginas, precio) VALUES ('SQL Avanzado', 'Miguel Torres', 'Bases de datos', 390, 29.99);
INSERT INTO libro (titulo, autor, genero, paginas, precio) VALUES ('Docker desde cero', 'John Smith', 'DevOps', 280, 21.50);

INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, devuelto, socio_id, libro_id) VALUES ('2026-05-01', '2026-05-10', 1, 1, 1);
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, devuelto, socio_id, libro_id) VALUES ('2026-05-02', NULL, 0, 1, 2);
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, devuelto, socio_id, libro_id) VALUES ('2026-05-03', '2026-05-15', 1, 2, 3);
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, devuelto, socio_id, libro_id) VALUES ('2026-05-04', NULL, 0, 3, 4);
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, devuelto, socio_id, libro_id) VALUES ('2026-05-05', NULL, 0, 4, 5);
INSERT INTO prestamo (fecha_prestamo, fecha_devolucion, devuelto, socio_id, libro_id) VALUES ('2026-05-06', '2026-05-20', 1, 2, 6);