CREATE TABLE Habitacion (
                            ID INT PRIMARY KEY,
                            Numero INT,
                            Tipo VARCHAR(50),
                            Capacidad INT
);

CREATE TABLE Extras (
                        ID INT PRIMARY KEY,
                        Nombre VARCHAR(50),
                        Precio DECIMAL(5,2)
);

CREATE TABLE Regimen (
                         ID INT PRIMARY KEY,
                         Tipo VARCHAR(50),
                         Descripcion VARCHAR(255)
);

CREATE TABLE Reserva (
                         ID INT PRIMARY KEY,
                         FechaInicio DATE,
                         FechaFin DATE,
                         HabitacionID INT,
                         ExtrasID INT,
                         RegimenID INT,
                         FOREIGN KEY (HabitacionID) REFERENCES Habitacion(ID),
                         FOREIGN KEY (ExtrasID) REFERENCES Extras(ID),
                         FOREIGN KEY (RegimenID) REFERENCES Regimen(ID)
);
