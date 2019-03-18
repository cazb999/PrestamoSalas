use db_gos;

show tables;
select * from prestamosala;
select * from tipo;
desc usuario;
insert into carrera values(null,"Ing Minas");
insert into tipo values(null, "Becario");
delete from prestamosala where idprestamosala = 3;

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

insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values ("2019-03-17","10:00:00","2019-03-17","12:00:00",1,1);
insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values ("2019-03-17","14:00:00","2019-03-17","16:00:00",1,1);
insert into prestamosala (DIAPRESTAMOSALA, HORAINICIO, DIADEVOLUCIONSALA, HORAFIN, IDUSUARIO, IDSALA) values ("2019-03-17","18:00:00","2019-03-17","20:00:00",1,1);

-- poblacion prestamo equipo
