use db_gos;

show tables;
select * from prestamosala;
select * from tipo;
select * from equipo;
desc usuario;
insert into carrera values(null,"Ing Minas");
insert into tipo values(null, "Becario");
delete from usuario where idusuario = 6;

-- poblacion Sala
insert into sala values(null,"A101",20);
insert into sala values(null,"A201",20);
insert into sala values(null,"A301",20);
insert into sala values(null,"A401",20);
insert into sala values(null,"A501",20);

-- poblacion Equipo
insert into equipo values(null,"E01",1);
insert into equipo values(null,"E02",1);
insert into equipo values(null,"E03",1);
insert into equipo values(null,"E01",2);
insert into equipo values(null,"E02",2);
insert into equipo values(null,"E03",2);
insert into equipo values(null,"E01",3);
insert into equipo values(null,"E02",3);
insert into equipo values(null,"E03",3);
insert into equipo values(null,"E01",4);
insert into equipo values(null,"E02",4);
insert into equipo values(null,"E03",4);
insert into equipo values(null,"E01",5);
insert into equipo values(null,"E02",5);
insert into equipo values(null,"E03",5);

-- poblacion prestamo sala
insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values ("2019-03-11","10:00:00","2019-03-11","12:00:00",1,1);
insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values ("2019-03-12","10:00:00","2019-03-12","12:00:00",1,1);

insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values ("2019-03-18","10:00:00","2019-03-18","12:00:00",1,1);
insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values ("2019-03-18","14:00:00","2019-03-18","16:00:00",1,1);
insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values ("2019-03-18","18:00:00","2019-03-18","20:00:00",1,1);

insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values ("2019-03-19","10:00:00","2019-03-19","00:00:00",1,1);
SELECT * FROM PRESTAMOSALA;
delete from prestamosala where idprestamosala = 10;

-- poblacion carrera
insert into carrera values(null,"Ing sistemas");
insert into carrera values(null,"Ing industrial");
insert into carrera values(null,"Ing Minas");

-- poblacion tipo
insert into tipo values(null,"Estudiante");
insert into tipo values(null,"Docente");
insert into tipo values(null,"Administrativo");
insert into tipo values(null,"Becario");
insert into tipo values(null,"Admin");

-- poblacion usuario
insert into usuario values(null,1,4,201320556,"Carlos","Zambrano","carlos@uotc.edu.co","1234");
insert into usuario values(null,1,4,201320111,"Pepito","Zambrano","carlos@uotc.edu.co","1234");
insert into usuario values(null,1,4,201320222,"Alberto","Braydi","carlos@uotc.edu.co","1234");
insert into usuario values(null,null,5,201320333,"Admin","Admin","admin@uptc.edu.co","1234");
