
-- Datos de prueba
-- para acceder a la consola h2 y ver los datos -> http://localhost:8080/h2-console (con la URL JDBC jdbc:h2:mem:testdb)


INSERT INTO Equipo (nombre) VALUES ('Real Madrid CF');
INSERT INTO Equipo (nombre) VALUES ('FC Barcelona');
INSERT INTO Equipo (nombre) VALUES ('Atlético de Madrid');
INSERT INTO Equipo (nombre) VALUES ('Sevilla FC');


INSERT INTO Estadio (nombre, aforo) VALUES ('Santiago Bernabéu', 81044);
INSERT INTO Estadio (nombre, aforo) VALUES ('Camp Nou', 99354);
INSERT INTO Estadio (nombre, aforo) VALUES ('Metropolitano', 68456);
INSERT INTO Estadio (nombre, aforo) VALUES ('Sánchez Pizjuán', 43883);


INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('11111111A', 'Jude', 'Bellingham');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('22222222B', 'Vinícius', 'Júnior');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('33333333C', 'Kylian', 'Mbappé');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('44444444D', 'Aurélien', 'Tchouaméni');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('55555555E', 'Eduardo', 'Camavinga');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('66666666F', 'Rodrygo', 'Goes');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('77777777G', 'Thibaut', 'Courtois');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('88888888H', 'Daniel', 'Carvajal');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('99999999I', 'Lamine', 'Yamal');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('10101010J', 'Pedro', 'González');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('12121212K', 'Pablo', 'Páez');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('13131313L', 'Frenkie', 'de Jong');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('14141414M', 'Ronald', 'Araújo');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('15151515N', 'Robert', 'Lewandowski');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('16161616O', 'Joan', 'García');
INSERT INTO Jugador (nif, nombre, apellidos) VALUES ('17171717P', 'Pau', 'Cubarsí');


INSERT INTO Partido (resultado, equipo_local_id, equipo_visitante_id, fecha) 
VALUES ('3-1', 1, 2, '2025-12-14');

INSERT INTO Partido (resultado, equipo_local_id, equipo_visitante_id, fecha) 
VALUES ('0-0', 3, 4, '2025-12-14');

INSERT INTO Partido (resultado, equipo_local_id, equipo_visitante_id, fecha) 
VALUES ('1-2', 2, 3, '2025-12-14');

INSERT INTO Partido (resultado, equipo_local_id, equipo_visitante_id, fecha) 
VALUES ('5-0', 1, 4, '2025-12-14');