-- EQUIPOS
INSERT INTO Equipo (nombre) VALUES ('Real Madrid CF');
INSERT INTO Equipo (nombre) VALUES ('FC Barcelona');
INSERT INTO Equipo (nombre) VALUES ('Atlético de Madrid');
INSERT INTO Equipo (nombre) VALUES ('Sevilla FC');

-- ESTADIOS
INSERT INTO Estadio (nombre, aforo) VALUES ('Santiago Bernabéu', 81044);
INSERT INTO Estadio (nombre, aforo) VALUES ('Camp Nou', 99354);
INSERT INTO Estadio (nombre, aforo) VALUES ('Metropolitano', 68456);
INSERT INTO Estadio (nombre, aforo) VALUES ('Sánchez Pizjuán', 43883);

-- Real Madrid CF (ID 1)
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('11111111A', 'Jude', 'Bellingham', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('22222222B', 'Vinícius', 'Júnior', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('33333333C', 'Kylian', 'Mbappé', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('44444444D', 'Aurélien', 'Tchouaméni', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('55555555E', 'Eduardo', 'Camavinga', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('66666666F', 'Rodrygo', 'Goes', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('77777777G', 'Thibaut', 'Courtois', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('88888888H', 'Daniel', 'Carvajal', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('18181818Q', 'Federico', 'Valverde', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('19191919R', 'Antonio', 'Rüdiger', 1);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('20202020S', 'Dean', 'Huijsen', 1);

-- FC Barcelona (ID 2)
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('99999999I', 'Lamine', 'Yamal', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('10101010J', 'Pedro', 'González', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('12121212K', 'Pablo', 'Páez', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('13131313L', 'Frenkie', 'de Jong', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('14141414M', 'Ronald', 'Araújo', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('15151515N', 'Robert', 'Lewandowski', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('16161616O', 'Joan', 'García', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('17171717P', 'Pau', 'Cubarsí', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('21212121T', 'Marcus', 'Rashford', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('22222222U', 'Raphinha', 'Dias', 2);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('23232323V', 'Jules', 'Koundé', 2);

-- Atlético de Madrid (ID 3)
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('30303030A', 'Jan', 'Oblak', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('31313131B', 'Antoine', 'Griezmann', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('32323232C', 'Julián', 'Álvarez', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('33333333D', 'Rodrigo', 'de Paul', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('34343434E', 'Koke', 'Resurrección', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('35353535F', 'Marcos', 'Llorente', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('36363636G', 'Robin', 'Le Normand', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('37373737H', 'José María', 'Giménez', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('38383838I', 'Conor', 'Gallagher', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('39393939J', 'Samuel', 'Lino', 3);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('40404040K', 'Nahuel', 'Molina', 3);

-- Sevilla FC (ID 4)
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('50505050L', 'Ørjan', 'Nyland', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('51515151M', 'Jesús', 'Navas', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('52525252N', 'Loïc', 'Badé', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('53535353O', 'Saúl', 'Ñíguez', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('54545454P', 'Isaac', 'Romero', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('55555555Q', 'Dodi', 'Lukebakio', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('56565656R', 'Albert Sambi', 'Lokonga', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('57575757S', 'Nemanja', 'Gudelj', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('58585858T', 'Djibril', 'Sow', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('59595959U', 'Valentín', 'Barco', 4);
INSERT INTO Jugador (nif, nombre, apellidos, id_equipo) VALUES ('60606060V', 'Gerard', 'Fernández', 4);

-- PARTIDOS
INSERT INTO Partido (resultado, fecha) VALUES ('3-1', '2025-01-10');
INSERT INTO Partido (resultado, fecha) VALUES ('0-0', '2025-01-10');
INSERT INTO Partido (resultado, fecha) VALUES ('1-2', '2025-01-10');
INSERT INTO Partido (resultado, fecha) VALUES ('5-0', '2025-01-10');