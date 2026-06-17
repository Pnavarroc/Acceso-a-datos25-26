INSERT INTO cliente (id, nif, nombre, ciudad, telefono) VALUES (1, '12345678A', 'Pablo Navarro', 'Teruel', '600111222');
INSERT INTO cliente (id, nif, nombre, ciudad, telefono) VALUES (2, '87654321B', 'Lucia Martinez', 'Zaragoza', '600333444');
INSERT INTO cliente (id, nif, nombre, ciudad, telefono) VALUES (3, '56781234C', 'Carlos Gomez', 'Valencia', '600555666');
INSERT INTO cliente (id, nif, nombre, ciudad, telefono) VALUES (4, '43218765D', 'Ana Lopez', 'Madrid', '600777888');
INSERT INTO cliente (id, nif, nombre, ciudad, telefono) VALUES (5, '99999999Z', 'Javier Sanz', 'Teruel', '600999000');

INSERT INTO coche (id, matricula, marca, modelo, color, precio, cliente_id) VALUES (1, '1111AAA', 'Alfa Romeo', '147', 'Rojo', 6000, 1);
INSERT INTO coche (id, matricula, marca, modelo, color, precio, cliente_id) VALUES (2, '2222BBB', 'Seat', 'Leon', 'Negro', 8500, 1);
INSERT INTO coche (id, matricula, marca, modelo, color, precio, cliente_id) VALUES (3, '3333CCC', 'BMW', '320d', 'Azul', 14500, 2);
INSERT INTO coche (id, matricula, marca, modelo, color, precio, cliente_id) VALUES (4, '4444DDD', 'Audi', 'A3', 'Blanco', 12000, 2);
INSERT INTO coche (id, matricula, marca, modelo, color, precio, cliente_id) VALUES (5, '5555EEE', 'Seat', 'Ibiza', 'Rojo', 5000, 3);
INSERT INTO coche (id, matricula, marca, modelo, color, precio, cliente_id) VALUES (6, '6666FFF', 'Ford', 'Focus', 'Gris', 7500, 3);
INSERT INTO coche (id, matricula, marca, modelo, color, precio, cliente_id) VALUES (7, '7777GGG', 'Alfa Romeo', 'Giulietta', 'Rojo', 9500, 3);
INSERT INTO coche (id, matricula, marca, modelo, color, precio, cliente_id) VALUES (8, '8888HHH', 'Mercedes', 'Clase A', 'Negro', 21000, 4);

INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (1, 'REV-001', true, true, 180, 1);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (2, 'REV-002', false, true, 90, 1);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (3, 'REV-003', true, false, 120, 2);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (4, 'REV-004', true, true, 250, 3);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (5, 'REV-005', true, false, 140, 3);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (6, 'REV-006', false, true, 100, 3);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (7, 'REV-007', false, false, 60, 5);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (8, 'REV-008', true, true, 200, 6);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (9, 'REV-009', false, true, 80, 6);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (10, 'REV-010', true, true, 300, 8);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (11, 'REV-011', true, true, 280, 8);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (12, 'REV-012', false, true, 110, 8);
INSERT INTO revision (id, codigo, cambio_aceite, cambio_filtro, coste, coche_id) VALUES (13, 'REV-013', true, false, 160, 8);

ALTER TABLE cliente ALTER COLUMN id RESTART WITH 6;
ALTER TABLE coche ALTER COLUMN id RESTART WITH 9;
ALTER TABLE revision ALTER COLUMN id RESTART WITH 14;