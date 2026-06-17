INSERT INTO cliente(nombre,nif,telefono,ciudad) VALUES ('Pablo Navarro', '23456787A','454545454', 'Teruel');
INSERT INTO cliente(nombre,nif,telefono,ciudad) VALUES ('Raul García Navarro', '23123487A','6666654', 'Monaco');
INSERT INTO cliente(nombre,nif,telefono,ciudad) VALUES ('Penelope CRUZ Navarro', '56565655P','466666454', 'Villareal');



INSERT INTO vehiculo(matricula,marca,modelo,anio,cliente_id) VALUES ('2555MPL', 'Alfa Romeo','Guillieta', 2004, 1);
INSERT INTO vehiculo(matricula,marca,modelo,anio,cliente_id) VALUES ('5566UHJ', 'Seat','Leon', 2020, 1);
INSERT INTO vehiculo(matricula,marca,modelo,anio,cliente_id) VALUES ('4411KKK', 'Seat','Ibiza', 2010, 2);
INSERT INTO vehiculo(matricula,marca,modelo,anio,cliente_id) VALUES ('5566PLM', 'Opel','Astra', 2020, 2);
INSERT INTO vehiculo(matricula,marca,modelo,anio,cliente_id) VALUES ('4477MMM', 'Opel','Kadett', 2020, 3);
INSERT INTO vehiculo(matricula,marca,modelo,anio,cliente_id) VALUES ('4477EEE', 'Seat','Leon', 2002, 3);

INSERT INTO reparacion(fecha,descripcion,coste,estado,vehiculo_id) VALUES('2022-01-10','Se ha roto el turbo',1500.0,'PENDIENTE',1);
INSERT INTO reparacion(fecha,descripcion,coste,estado,vehiculo_id) VALUES('2025-06-12','Cambio de aceite',100.0,'FINALIZADA',1);
INSERT INTO reparacion(fecha,descripcion,coste,estado,vehiculo_id) VALUES('2026-05-15','Luna rota',1000.0,'EN_PROCESO',2);
INSERT INTO reparacion(fecha,descripcion,coste,estado,vehiculo_id) VALUES('2026-06-10','Correa de distribucion',1500.0,'FINALIZADA',2);
INSERT INTO reparacion(fecha,descripcion,coste,estado,vehiculo_id) VALUES('2026-06-17','Se ha roto el turbo',1500.0,'PENDIENTE',3);

