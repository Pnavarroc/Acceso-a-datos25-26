INSERT INTO paciente(nombre,nif,telefono,ciudad) VALUES ('Pablo Navarro','12345678A','600111111','Teruel');
INSERT INTO paciente(nombre,nif,telefono,ciudad) VALUES ('Lucia Perez','87654321B','600222222','Zaragoza');
INSERT INTO paciente(nombre,nif,telefono,ciudad) VALUES ('Mario Lopez','11223344C','600333333','Valencia');


INSERT INTO dentista(nombre,especialidad,numero_colegiado) VALUES ('Juan Martinez','Ortodoncia','COL001');
INSERT INTO dentista(nombre,especialidad,numero_colegiado) VALUES ('Ana Gomez','Implantologia','COL002');

INSERT INTO cita(fecha,hora,motivo,precio,estado,dentista_id,paciente_id) VALUES('2026-06-20',10,'Limpieza',50,'PENDIENTE',1,1);
INSERT INTO cita(fecha,hora,motivo,precio,estado,dentista_id,paciente_id) VALUES ('2026-06-21',12,'Revision',30,'REALIZADA',2,2);
INSERT INTO cita(fecha,hora,motivo,precio,estado,dentista_id,paciente_id) VALUES ('2026-06-22',16,'Empaste',80,'CANCELADA',1,3);

