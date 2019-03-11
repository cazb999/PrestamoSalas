CREATE TABLE IF NOT EXISTS `db_gos`.`carrera` (
  `IDCARRERA` INT(11) NOT NULL AUTO_INCREMENT,
  `NOMBRECARRERA` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IDCARRERA`),
  UNIQUE INDEX `CARRERA_PK` (`IDCARRERA` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_gos`.`sala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gos`.`sala` (
  `IDSALA` INT(11) NOT NULL AUTO_INCREMENT,
  `NOMBRESALA` VARCHAR(50) NOT NULL,
  `CAPACIDADSALA` INT(11) NOT NULL,
  PRIMARY KEY (`IDSALA`),
  UNIQUE INDEX `SALA_PK` (`IDSALA` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_gos`.`equipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gos`.`equipo` (
  `IDEQUIPO` INT(11) NOT NULL AUTO_INCREMENT,
  `NOMBREEQUIPO` VARCHAR(45) NOT NULL,
  `IDSALA` INT(11) NOT NULL,
  PRIMARY KEY (`IDEQUIPO`),
  INDEX `fk_Equipo_sala1_idx` (`IDSALA` ASC),
  CONSTRAINT `fk_Equipo_sala1`
    FOREIGN KEY (`IDSALA`)
    REFERENCES `db_gos`.`sala` (`IDSALA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_gos`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gos`.`tipo` (
  `IDTIPO` INT(11) NOT NULL AUTO_INCREMENT,
  `NOMBRETIPO` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`IDTIPO`),
  UNIQUE INDEX `TIPO_PK` (`IDTIPO` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_gos`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gos`.`usuario` (
  `IDUSUARIO` INT(11) NOT NULL AUTO_INCREMENT,
  `IDCARRERA` INT(11) NULL DEFAULT NULL,
  `IDTIPO` INT(11) NOT NULL,
  `CODIGOUSUARIO` INT(11) NOT NULL,
  `NOMBREUSUARIO` VARCHAR(50) NOT NULL,
  `APELLIDOUSUARIO` VARCHAR(50) NOT NULL,
  `CORREO` VARCHAR(45) NOT NULL,
  `CONTRASENA` VARCHAR(45) NULL,
  PRIMARY KEY (`IDUSUARIO`),
  UNIQUE INDEX `USUARIO_PK` (`IDUSUARIO` ASC),
  INDEX `RELATIONSHIP_1_FK` (`IDTIPO` ASC),
  INDEX `RELATIONSHIP_2_FK` (`IDCARRERA` ASC),
  CONSTRAINT `FK_USUARIO_RELATIONS_CARRERA`
    FOREIGN KEY (`IDCARRERA`)
    REFERENCES `db_gos`.`carrera` (`IDCARRERA`),
  CONSTRAINT `FK_USUARIO_RELATIONS_TIPO`
    FOREIGN KEY (`IDTIPO`)
    REFERENCES `db_gos`.`tipo` (`IDTIPO`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_gos`.`prestamoEquipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gos`.`prestamoEquipo` (
  `IDPRESTAMOEQUIPO` INT(11) NOT NULL AUTO_INCREMENT,
  `IDUSUARIO` INT(11) NOT NULL,
  `IDEQUIPO` INT(11) NOT NULL,
  `DIAPRESTAMOEQUIPO` DATE NOT NULL,
  `HORAINICIO` TIME NOT NULL,
  `HORAFIN` TIME NULL DEFAULT NULL,
  `DIADEVOLUCIONEQUIPO` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`IDPRESTAMOEQUIPO`),
  UNIQUE INDEX `ESTUDIANTEEQUIPO_PK` (`IDPRESTAMOEQUIPO` ASC),
  INDEX `fk_estudianteequipo_usuario1_idx` (`IDUSUARIO` ASC),
  INDEX `fk_estudianteequipo_Equipo1_idx` (`IDEQUIPO` ASC),
  CONSTRAINT `fk_estudianteequipo_usuario1`
    FOREIGN KEY (`IDUSUARIO`)
    REFERENCES `db_gos`.`usuario` (`IDUSUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_estudianteequipo_Equipo1`
    FOREIGN KEY (`IDEQUIPO`)
    REFERENCES `db_gos`.`equipo` (`IDEQUIPO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `db_gos`.`prestamoSala`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `db_gos`.`prestamoSala` (
  `IDPRESTAMOSALA` INT(11) NOT NULL AUTO_INCREMENT,
  `DIAPRESTAMOSALA` DATE NOT NULL,
  `HORAINICIO` TIME NOT NULL,
  `DIADEVOLUCIONSALA` DATE NULL DEFAULT NULL,
  `HORAFIN` TIME NULL DEFAULT NULL,
  `IDUSUARIO` INT(11) NOT NULL,
  `IDSALA` INT(11) NOT NULL,
  PRIMARY KEY (`IDPRESTAMOSALA`),
  UNIQUE INDEX `PRESTAMOSALA_PK` (`IDPRESTAMOSALA` ASC),
  INDEX `fk_prestamosala_usuario1_idx` (`IDUSUARIO` ASC),
  INDEX `fk_prestamosala_sala1_idx` (`IDSALA` ASC),
  CONSTRAINT `fk_prestamosala_usuario1`
    FOREIGN KEY (`IDUSUARIO`)
    REFERENCES `db_gos`.`usuario` (`IDUSUARIO`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_prestamosala_sala1`
    FOREIGN KEY (`IDSALA`)
    REFERENCES `db_gos`.`sala` (`IDSALA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;