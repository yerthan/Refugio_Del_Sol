CREATE database IF NOT EXISTS refugio_del_sol;

USE refugio_del_sol;

CREATE TABLE Habitacion (
                            ID INT PRIMARY KEY AUTO_INCREMENT,
                            Numero INT,
                            Tipo VARCHAR(50),
                            Capacidad INT,
                            Precio DECIMAL(5,2)
);

CREATE TABLE Extras (
                        ID INT PRIMARY KEY AUTO_INCREMENT,
                        Nombre VARCHAR(50),
                        Precio DECIMAL(5,2)
);

CREATE TABLE Regimen (
                         ID INT PRIMARY KEY AUTO_INCREMENT,
                         Tipo VARCHAR(50),
                         Descripcion VARCHAR(255),
                         Precio DECIMAL(5,2)
);

CREATE TABLE Reserva (
                         ID INT PRIMARY KEY AUTO_INCREMENT,
                         FechaInicio DATE,
                         FechaFin DATE,
                         HabitacionID INT,
                         ExtrasID INT,
                         RegimenID INT,
                         FOREIGN KEY (HabitacionID) REFERENCES Habitacion(ID),
                         FOREIGN KEY (ExtrasID) REFERENCES Extras(ID),
                         FOREIGN KEY (RegimenID) REFERENCES Regimen(ID)
);

-- turista: 100e
-- suite: 200e
-- Habitaciones con capacidad 1 : 0€
INSERT INTO Habitacion (Numero, Tipo, Capacidad, Precio) VALUES
                                                             (1, 'suite', 1, 0),
                                                             (2, 'suite', 1, 0),
                                                             (3, 'suite', 1, 0),
                                                             (4, 'turista', 1, 100),
                                                             (5, 'turista', 1, 100),
                                                             (6, 'turista', 1, 100);

-- Habitaciones con capacidad 2 : 50€
INSERT INTO Habitacion (Numero, Tipo, Capacidad, Precio) VALUES
                                                             (7, 'suite', 2, 50),
                                                             (8, 'suite', 2, 50),
                                                             (9, 'suite', 2, 50),
                                                             (10, 'turista', 2, 150),
                                                             (11, 'turista', 2, 150),
                                                             (12, 'turista', 2, 150),
                                                             (13, 'turista', 2, 150);

-- Habitaciones con capacidad 3 : 80€
INSERT INTO Habitacion (Numero, Tipo, Capacidad, Precio) VALUES
                                                             (14, 'suite', 3, 80),
                                                             (15, 'suite', 3, 80),
                                                             (16, 'suite', 3, 80),
                                                             (17, 'turista', 3, 180),
                                                             (18, 'turista', 3, 180),
                                                             (19, 'turista', 3, 180),
                                                             (20, 'suite', 3, 280);