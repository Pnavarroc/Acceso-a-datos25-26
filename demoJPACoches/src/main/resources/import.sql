--create table Coche (
--	id INT,
--	marca VARCHAR(50),
--	modelo VARCHAR(50),
--	matricula VARCHAR(50),
--	cilindrada DECIMAL(5,1),
--	potencia INT,
--	color VARCHAR(50)
--);


insert into Persona(id, nombre, apellido) values (1, 'Antonio', 'Lopez');
insert into Persona(id, nombre, apellido) values (2, 'Pepelu', 'Martinez');
insert into Persona(id, nombre, apellido) values (3, 'Pablo', 'Sanchez');


insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (1, 'Volkswagen', 'Passat', 'W04G05GV0B1473238', 7310.1, 656, 'Aquamarine',1);
insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (2, 'Lexus', 'LS', '1D7RE2GK8BS166632', 3605.5, 295, 'Orange',2);
insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (3, 'Jeep', 'Wrangler', '1G6AK5SX6D0525529', 3758.2, 638, 'Teal',3);
insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (4, 'Honda', 'CR-X', 'WAUVT58E75A282792', 2378.1, 291, 'Green',1);
insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (5, 'Mazda', 'RX-7', 'JH4CW2H50DC092463', 3532.7, 556, 'Green',2);
insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (6, 'Volkswagen', 'Cabriolet', '1FTMF1EWXAF943656', 2509.2, 773, 'Maroon',3);
insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (7, 'Mercedes-Benz', 'SLK-Class', '19VDE1F39FE659522', 3541.5, 654, 'Red',1);
insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (8, 'Audi', 'S5', 'WAUBH78EX8A589667', 2350.9, 658, 'Aquamarine',2);
insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (9, 'Mitsubishi', 'Precis', 'JN1CV6FE7BM171895', 3240.7, 57, 'Blue',3);
insert into Coche (id, marca, modelo, matricula, cilindrada, potencia, color, persona_id) values (10, 'Honda', 'Accord', 'KMHFG4JG9DA497425', 2980.8, 439, 'Purple',1);

