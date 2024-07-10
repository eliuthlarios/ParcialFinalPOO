create  database BancoBCN2024 --00103923 Se crea la base de datos
use BancoBCN2024 --00103923 Se selecciona la base de datos para poder usarla

CREATE TABLE Clientes ( --00103923 Se crea la tabla Clientes
    ClienteID INT PRIMARY KEY IDENTITY(1,1), --00103923 Se define ClienteID como un entero llave primaria
    NombreCompleto VARCHAR(255) NOT NULL, --00103923 Se define NombreCompleto como VARCHAR no nulo
    Direccion VARCHAR(255) NOT NULL, --00103923 Se define Dirección como VARCHAR no nulo
    NumeroTelefono VARCHAR(15) NOT NULL --00103923 Se define NumeroTelefono como VARCHAR no nulo
);

CREATE TABLE Tarjetas ( --00103923 Se crea la tabla Tarjetas
    NumeroTarjeta VARCHAR(16) PRIMARY KEY, --00103923 Se define NumeroTarjeta como un VARCHAR llave primaria
    FechaExpiracion DATE NOT NULL, --00103923 Se define FechaExpiracion como un DATE no nulo
    TipoTarjeta VARCHAR(10) NOT NULL, --00103923 Se define TipoTarjeta como un VARCHAR no nulo
    Facilitador VARCHAR(50) NOT NULL, --00103923 Se define facilitador como un VARCHAR no nulo
    ClienteID INT NOT NULL, --00103923 Se define ClienteID como un entero no nulo
    FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID) --00103923 Se establece ClienteID como llave foranea refernciando al ClienteID de la tabla Clientes
);
--00103923 Añade una restriccion a la llave foranea de eliminacion on cascade para ClientesID en la tabla Tarjetas
ALTER TABLE Tarjetas ADD CONSTRAINT FK_Tarjetas_IdCliente FOREIGN KEY (ClienteID) REFERENCES Clientes(ClienteID) ON DELETE CASCADE;

CREATE TABLE Transacciones ( --00103923 Se crea la tabla Transacciones
    TransaccionID INT PRIMARY KEY IDENTITY(1,1), --00103923 Se define TransaccionID como un entero llave primaria
    FechaCompra DATE NOT NULL, --00103923 Se define FechaCompra como un DATE no nulo
    MontoTotal DECIMAL(10, 2) NOT NULL, --00103923 Se define MontoTotal como un DECIMAL no nulo
    Descripcion VARCHAR(255) NOT NULL, --00103923 Se define Descripcion como un VARCHAR no nulo
    NumeroTarjeta VARCHAR(16) NOT NULL, --00103923 Se define NumeroTarjeta como un VARCHAR no nulo
    FOREIGN KEY (NumeroTarjeta) REFERENCES Tarjetas(NumeroTarjeta) --00103923 Se establece NumeroTarjeta como llave foranea referenciando a NumeroTarjeta de la tabla Tarjetas
);
--00103923 Añade una restriccion a la llave foranea de eliminacion on cascade para NumeroTarjeta en la tabla Transacciones
ALTER TABLE Transacciones ADD CONSTRAINT FK_Transacciones_NumeroTarjeta FOREIGN KEY (NumeroTarjeta) REFERENCES Tarjetas(NumeroTarjeta) ON DELETE CASCADE;

CREATE OR ALTER PROCEDURE AgregarNuevaTarjetaAClienteExistente --00103923 Se crea o altera el procedimiento almacenado AgregarNuevaTarjetaAClienteExistente
    @ClienteID INT, --00103923 Define el parametro ClienteID como entero
    @NuevoNumeroTarjeta VARCHAR(16), --00103923 Se define el parametro NuevoNumeroTarjeta como VARCHAR
    @FechaExpiracion DATE --00103923 Se define el parametro FechaExpiracion como DATE
AS
BEGIN --00103923 Inicio del bloque del procedimiento
    SET NOCOUNT ON; --00103923 Desactiva el conteo de las filas afectadas

    IF EXISTS (SELECT 1 FROM Clientes WHERE ClienteID = @ClienteID) --00103923 Verifica si existe el ClienteID en la tabla Cliente
    BEGIN --00103923 Inicio del IF
        IF NOT EXISTS (SELECT 1 FROM Tarjetas WHERE NumeroTarjeta = @NuevoNumeroTarjeta) --00103923 Verifica si el numero de la nueva tarjeta no existe previamente en la tabla Tarjetas
        BEGIN --00103923 Inicio del segundo IF anidado
            DECLARE @TipoTarjeta VARCHAR(10), @Facilitador VARCHAR(50); --00103923 Declaracion de las variable TipoTarjeta y Facilitador como VARCHAR
            SELECT TOP 1 @TipoTarjeta = TipoTarjeta, @Facilitador = Facilitador
            FROM Tarjetas 
            WHERE ClienteID = @ClienteID; --00103923 Asigna valores a TipoTarjeta y Facilitador de una tarjeta del cliente.

            INSERT INTO Tarjetas (NumeroTarjeta, FechaExpiracion, TipoTarjeta, Facilitador, ClienteID) 
			VALUES (@NuevoNumeroTarjeta, @FechaExpiracion, @TipoTarjeta, @Facilitador, @ClienteID); --00103923 Inserta una nueva tarjeta en la tabla Tarjetas

            PRINT 'Nueva tarjeta añadida correctamente.'; --00103923 Muestra mensaje de operacion exitosa
        END --00103923 Fin del segundo bloque IF anidado
        ELSE 
        BEGIN --00103923 Inicio del bloque ELSE anidado
            RAISERROR('La tarjeta ya existe en la base de datos.', 16, 1); --00103923 Muestra un error de que la tarjeta ya existe
        END --00103923 Fin del bloque ELSE anidado
    END --00103923 Fin del bloque IF
    ELSE
    BEGIN --00103923 Inicio del bloque ELSE
        RAISERROR('El cliente no existe.', 16, 1); --00103923 Muestra error si el cliente no existe
    END --00103923 Fin del bloque ELSE
END; --00103923 Fin del proceso almacenado

-- Procedimiento para insertar transaccion verificando si la tarjeta existe
CREATE OR ALTER PROCEDURE InsertarTransaccion --00103923 Crea o altera el procedimiento almacenado InsertarTransaccion
    @NumeroTarjeta VARCHAR(16), --00103923 Define el parametro NumeroTarjeta como VARCHAR
    @MontoTotal DECIMAL(10, 2), --00103923 Define el parametro MontoTotal como DECIMAL
    @Descripcion VARCHAR(255) --00103923 Define el parametro Descripcion como VARCHAR
AS
BEGIN --00103923 Inicio del bloque del procedimiento almacenado
    SET NOCOUNT ON; --00103923 Desactiva el conteo de filas afectadas

    IF EXISTS (SELECT 1 FROM Tarjetas WHERE NumeroTarjeta = @NumeroTarjeta) --00103923 Verifica si el NumeroTarjeta existe en la tabla Tarjetas.
    BEGIN --00103923 Inicio del bloque IF
        INSERT INTO Transacciones (NumeroTarjeta, FechaCompra, MontoTotal, Descripcion)
        VALUES (@NumeroTarjeta, GETDATE(), @MontoTotal, @Descripcion); --00103923 Inserta una nueva transaccion en la tabla Transacciones
    END --00103923 Fin del bloque IF
    ELSE 
    BEGIN --00103923 Inicio del bloque ELSE
        RAISERROR('La tarjeta de credito proporcionada no existe.', 16, 1); --00103923 Muestra un error si la tarjeta no existe
    END --00103923 Fin del bloque ELSE
END; --00103923 Fin del procedimiento almacenado

 --Reporte A
CREATE OR ALTER PROCEDURE TransaccionesPorClienteYRangoDeFechas --00103923 Crea o altera el procedimiento almacenado TransaccionesPorClienteYRangoDeFechas
@ClienteID INT, --00103923 Define el parametro ClienteID como INT
@FechaInicio DATE, --00103923 Define el parametro FechaInicio como DATE
@FechaFin DATE --00103923 Define el parametro como FechaFin como DATE
AS
BEGIN --00103923 Inicio del bloque del procedimiento almacenado
    SELECT 
        'Num Transaccion: '+CAST(t.TransaccionID AS VARCHAR) + ', ' + 
        'Fecha: '+ FORMAT(t.FechaCompra,'dd-MM-yyyy') + ', ' + 
        'Monto: '+ CAST(t.MontoTotal AS VARCHAR) + ', ' + 
        'Descripcion: '+ t.Descripcion + ', ' + 
        'Tarjeta: XXXX XXXX XXXX '+ RIGHT(tc.NumeroTarjeta,4) AS Transacciones --00103923 Selecciona los datos de las transacciones del cliente en el rango de fechas
    FROM 
        Transacciones t
    INNER JOIN 
        Tarjetas tc ON t.NumeroTarjeta = tc.NumeroTarjeta --00103923 Une las tablas Transacciones y Tarjetas en base al NumeroTarjeta
    WHERE 
        tc.ClienteID = @ClienteID
        AND t.FechaCompra BETWEEN @FechaInicio AND @FechaFin --00103923 Filtra las transacciones segun el rango de fecha
    ORDER BY 
        t.FechaCompra; --00103923 Ordena las transacciones de acuerdo a la fecha de compra
END; --00103923 Fin del bloque del procedimiento almacenado

-- Reporte B
CREATE OR ALTER FUNCTION TotalGastadoPorClienteEnMes --00103923 Crea o altera la funcion TotalGastadoPorClienteEnMes
(
    @ClienteID INT, --00103923 Define el parametro ClienteID como INT
    @Mes INT, --00103923 Define el parametro Mes como INT
    @Anio INT --00103923 Define el parametro Ano como INT
)
RETURNS DECIMAL(10, 2) --00103923 Define el tipo de retorno de la funcion
AS
BEGIN --00103923 Inicio del bloque de la funcion
    DECLARE @TotalGastado DECIMAL(10, 2); --00103923 Declara la variable TotalGastado como DECIMAL

    SELECT @TotalGastado = ISNULL(SUM(MontoTotal), 0)
    FROM Transacciones AS t
    INNER JOIN Tarjetas AS ta ON t.NumeroTarjeta = ta.NumeroTarjeta
    WHERE ta.ClienteID = @ClienteID
      AND MONTH(t.FechaCompra) = @Mes
      AND YEAR(t.FechaCompra) = @Anio; --00103923 Calcula el total gastado por el cliente en el mes y año dados

    RETURN @TotalGastado; --00103923 Devuelve el valor de lo total gastado
END; --00103923 Fin del bloque de la funcion

SELECT dbo.TotalGastadoPorClienteEnMes(5, 7, 2024) AS TotalGastado; --00103923 Llama la funcion y muestra lo total gastado el 5 de julio de 2024

--Reporte C
CREATE OR ALTER PROCEDURE ListarTarjetasPorCliente --00103923 Crea o altera el procedimiento almacenado ListarTarjetasPorCliente
     @ClienteID INT --00103923 Defien el parametro ClienteID como INT
AS
BEGIN --00103923 Inicio del bloque del procedimiento almacenado
    SET NOCOUNT ON; --00103923 Desactiva el conteo de filas afectadas

    SELECT 
        CASE 
            WHEN TipoTarjeta = 'Credito' THEN 'Tarjeta de Credito: XXXX XXXX XXXX ' + RIGHT(NumeroTarjeta, 4)
            WHEN TipoTarjeta = 'Debito' THEN 'Tarjeta de Debito: XXXX XXXX XXXX ' + RIGHT(NumeroTarjeta, 4)
        END AS DetalleTarjeta 
    FROM Tarjetas
    WHERE ClienteID = @ClienteID; --00103923 Selecciona y formatea los detalles de las tarjetas del cliente
END; --00103923 Fin del bloque del procedimiento almacenado

-- Reporte D
CREATE OR ALTER PROCEDURE ReportePorFacilitador --00103923 Crea o altera el procedimiento almacenado ReportePorFacilitador
        @Facilitador VARCHAR(50) --00103923 Define el parametro Facilitador como VARCHAR
AS
BEGIN --00103923 Inicio del bloque del procedimiento almacenado
    SET NOCOUNT ON; --00103923 Desactiva el conteo de filas afectadas

    SELECT 
        'ID: ' + CAST(c.ClienteID AS VARCHAR) + ','+
        ' Nombre: ' + c.NombreCompleto + ','+
        ' Cantidad de Compras: ' + CAST(COUNT(t.TransaccionID) AS VARCHAR) + ','+
        ' Total Gastado: ' + CAST(SUM(t.MontoTotal) AS VARCHAR) AS Reporte
    FROM 
        Clientes AS c
    INNER JOIN 
        Tarjetas AS ta ON c.ClienteID = ta.ClienteID
    INNER JOIN 
        Transacciones AS t ON ta.NumeroTarjeta = t.NumeroTarjeta
    WHERE 
        ta.Facilitador = @Facilitador
    GROUP BY 
        c.ClienteID, c.NombreCompleto; --00103923 Selecciona y formatea los datos de los clientes y sus transacciones agrupados por facilitador.
END; --00103923 Fin del bloque del procedimiento almacenado

