-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 27, 2024 at 08:04 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datawarehouseventas`
--

-- --------------------------------------------------------

--
-- Table structure for table `dimcategorias`
--

CREATE TABLE `dimcategorias` (
  `CategoriaKey` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dimcategorias`
--

INSERT INTO `dimcategorias` (`CategoriaKey`, `Nombre`) VALUES
(1, 'Electrónica'),
(2, 'Accesorios'),
(3, 'Computación'),
(4, 'Hogar'),
(5, 'Oficina'),
(6, 'Automotriz'),
(7, 'Juguetes'),
(8, 'Ropa'),
(9, 'Deportes'),
(10, 'Salud');

-- --------------------------------------------------------

--
-- Table structure for table `dimclientes`
--

CREATE TABLE `dimclientes` (
  `ClienteKey` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Direccion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dimclientes`
--

INSERT INTO `dimclientes` (`ClienteKey`, `Nombre`, `Email`, `Telefono`, `Direccion`) VALUES
(1, 'Juan Pérez', 'juan.perez@gmail.com', '555-1234', 'Calle 1, Ciudad A'),
(2, 'Ana López', 'ana.lopez@gmail.com', '555-5678', 'Calle 2, Ciudad B'),
(3, 'Carlos Gómez', 'carlos.gomez@gmail.com', '555-8765', 'Calle 3, Ciudad C'),
(4, 'María Torres', 'maria.torres@gmail.com', '555-4321', 'Calle 4, Ciudad D'),
(5, 'Luis Fernández', 'luis.fernandez@gmail.com', '555-6789', 'Calle 5, Ciudad E'),
(6, 'Carmen Jiménez', 'carmen.jimenez@gmail.com', '555-9876', 'Calle 6, Ciudad F'),
(7, 'José Morales', 'jose.morales@gmail.com', '555-3456', 'Calle 7, Ciudad G'),
(8, 'Laura Suárez', 'laura.suarez@gmail.com', '555-6543', 'Calle 8, Ciudad H'),
(9, 'Ricardo Díaz', 'ricardo.diaz@gmail.com', '555-7890', 'Calle 9, Ciudad I'),
(10, 'Sandra Vargas', 'sandra.vargas@gmail.com', '555-0987', 'Calle 10, Ciudad J');

-- --------------------------------------------------------

--
-- Table structure for table `dimempleados`
--

CREATE TABLE `dimempleados` (
  `EmpleadoKey` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Puesto` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dimempleados`
--

INSERT INTO `dimempleados` (`EmpleadoKey`, `Nombre`, `Puesto`) VALUES
(1, 'Roberto Sánchez', 'Cajero'),
(2, 'Ana Beltrán', 'Gerente'),
(3, 'Mario Díaz', 'Vendedor'),
(4, 'Carolina López', 'Almacén'),
(5, 'Diego Torres', 'Supervisor'),
(6, 'Laura Gómez', 'Recepcionista'),
(7, 'Miguel Álvarez', 'Técnico'),
(8, 'Sara Ramírez', 'Asistente'),
(9, 'Manuel Jiménez', 'Administrador'),
(10, 'Claudia Vargas', 'Encargada de Compras');

-- --------------------------------------------------------

--
-- Table structure for table `dimmetodospago`
--

CREATE TABLE `dimmetodospago` (
  `MetodoKey` int NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dimmetodospago`
--

INSERT INTO `dimmetodospago` (`MetodoKey`, `Descripcion`) VALUES
(1, 'Efectivo'),
(2, 'Tarjeta de Crédito'),
(3, 'Tarjeta de Débito'),
(4, 'Transferencia Bancaria'),
(5, 'PayPal'),
(6, 'Criptomoneda'),
(7, 'Cheque'),
(8, 'Tarjeta Regalo'),
(9, 'Pago Contra Entrega'),
(10, 'Otro');

-- --------------------------------------------------------

--
-- Table structure for table `dimproductos`
--

CREATE TABLE `dimproductos` (
  `ProductoKey` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Precio` decimal(10,2) DEFAULT NULL,
  `CategoriaID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dimproductos`
--

INSERT INTO `dimproductos` (`ProductoKey`, `Nombre`, `Precio`, `CategoriaID`) VALUES
(1, 'Laptop', '1500.00', 3),
(2, 'Teléfono', '800.00', 1),
(3, 'Teclado', '50.00', 3),
(4, 'Monitor', '300.00', 3),
(5, 'Mouse', '25.00', 2),
(6, 'Impresora', '200.00', 5),
(7, 'Auriculares', '100.00', 2),
(8, 'Tablet', '400.00', 3),
(9, 'Cámara', '600.00', 1),
(10, 'Altavoces', '150.00', 2);

-- --------------------------------------------------------

--
-- Table structure for table `dimproveedores`
--

CREATE TABLE `dimproveedores` (
  `ProveedorKey` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Contacto` varchar(100) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dimproveedores`
--

INSERT INTO `dimproveedores` (`ProveedorKey`, `Nombre`, `Contacto`, `Telefono`) VALUES
(1, 'TechSupply', 'Luis Moreno', '555-1111'),
(2, 'HomeGadgets', 'María Pérez', '555-2222'),
(3, 'OfficeMart', 'Carlos Ruiz', '555-3333'),
(4, 'AutoTech', 'Ana Gómez', '555-4444'),
(5, 'SportShop', 'Javier Torres', '555-5555'),
(6, 'HealthPlus', 'Patricia Vargas', '555-6666'),
(7, 'ToyWorld', 'Pedro Jiménez', '555-7777'),
(8, 'WearNow', 'Sofía Morales', '555-8888'),
(9, 'GameZone', 'Martín Díaz', '555-9999'),
(10, 'CamStore', 'Lucía Fernández', '555-0000');

-- --------------------------------------------------------

--
-- Table structure for table `dimtiempo`
--

CREATE TABLE `dimtiempo` (
  `TiempoKey` date NOT NULL,
  `Año` int DEFAULT NULL,
  `Mes` int DEFAULT NULL,
  `Dia` int DEFAULT NULL,
  `DiaSemana` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `dimtiempo`
--

INSERT INTO `dimtiempo` (`TiempoKey`, `Año`, `Mes`, `Dia`, `DiaSemana`) VALUES
('2024-11-01', 2024, 11, 1, 'Friday'),
('2024-11-02', 2024, 11, 2, 'Saturday'),
('2024-11-03', 2024, 11, 3, 'Sunday'),
('2024-11-04', 2024, 11, 4, 'Monday'),
('2024-11-05', 2024, 11, 5, 'Tuesday'),
('2024-11-06', 2024, 11, 6, 'Wednesday'),
('2024-11-07', 2024, 11, 7, 'Thursday'),
('2024-11-08', 2024, 11, 8, 'Friday'),
('2024-11-09', 2024, 11, 9, 'Saturday'),
('2024-11-10', 2024, 11, 10, 'Sunday');

-- --------------------------------------------------------

--
-- Table structure for table `hechosventas`
--

CREATE TABLE `hechosventas` (
  `VentaKey` int NOT NULL,
  `ClienteKey` int DEFAULT NULL,
  `ProductoKey` int DEFAULT NULL,
  `CategoriaKey` int DEFAULT NULL,
  `ProveedorKey` int DEFAULT NULL,
  `TiempoKey` date DEFAULT NULL,
  `EmpleadoKey` int DEFAULT NULL,
  `MetodoKey` int DEFAULT NULL,
  `Cantidad` int DEFAULT NULL,
  `Total` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `hechosventas`
--

INSERT INTO `hechosventas` (`VentaKey`, `ClienteKey`, `ProductoKey`, `CategoriaKey`, `ProveedorKey`, `TiempoKey`, `EmpleadoKey`, `MetodoKey`, `Cantidad`, `Total`) VALUES
(1, 1, 1, 3, 1, '2024-11-01', 1, 2, 1, '1500.00'),
(2, 2, 2, 1, 2, '2024-11-02', 2, 3, 1, '800.00'),
(3, 3, 3, 3, 3, '2024-11-03', 3, 1, 2, '100.00'),
(4, 4, 4, 3, 1, '2024-11-04', 4, 4, 1, '300.00'),
(5, 5, 5, 2, 5, '2024-11-05', 5, 2, 3, '75.00'),
(6, 6, 6, 5, 6, '2024-11-06', 6, 3, 1, '200.00'),
(7, 7, 7, 2, 7, '2024-11-07', 7, 5, 1, '100.00'),
(8, 8, 8, 3, 8, '2024-11-08', 8, 1, 1, '400.00'),
(9, 9, 9, 1, 9, '2024-11-09', 9, 4, 1, '600.00'),
(10, 10, 10, 2, 10, '2024-11-10', 10, 2, 2, '300.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dimcategorias`
--
ALTER TABLE `dimcategorias`
  ADD PRIMARY KEY (`CategoriaKey`);

--
-- Indexes for table `dimclientes`
--
ALTER TABLE `dimclientes`
  ADD PRIMARY KEY (`ClienteKey`);

--
-- Indexes for table `dimempleados`
--
ALTER TABLE `dimempleados`
  ADD PRIMARY KEY (`EmpleadoKey`);

--
-- Indexes for table `dimmetodospago`
--
ALTER TABLE `dimmetodospago`
  ADD PRIMARY KEY (`MetodoKey`);

--
-- Indexes for table `dimproductos`
--
ALTER TABLE `dimproductos`
  ADD PRIMARY KEY (`ProductoKey`);

--
-- Indexes for table `dimproveedores`
--
ALTER TABLE `dimproveedores`
  ADD PRIMARY KEY (`ProveedorKey`);

--
-- Indexes for table `dimtiempo`
--
ALTER TABLE `dimtiempo`
  ADD PRIMARY KEY (`TiempoKey`);

--
-- Indexes for table `hechosventas`
--
ALTER TABLE `hechosventas`
  ADD PRIMARY KEY (`VentaKey`),
  ADD KEY `ClienteKey` (`ClienteKey`),
  ADD KEY `ProductoKey` (`ProductoKey`),
  ADD KEY `CategoriaKey` (`CategoriaKey`),
  ADD KEY `ProveedorKey` (`ProveedorKey`),
  ADD KEY `TiempoKey` (`TiempoKey`),
  ADD KEY `EmpleadoKey` (`EmpleadoKey`),
  ADD KEY `MetodoKey` (`MetodoKey`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hechosventas`
--
ALTER TABLE `hechosventas`
  ADD CONSTRAINT `hechosventas_ibfk_1` FOREIGN KEY (`ClienteKey`) REFERENCES `dimclientes` (`ClienteKey`),
  ADD CONSTRAINT `hechosventas_ibfk_2` FOREIGN KEY (`ProductoKey`) REFERENCES `dimproductos` (`ProductoKey`),
  ADD CONSTRAINT `hechosventas_ibfk_3` FOREIGN KEY (`CategoriaKey`) REFERENCES `dimcategorias` (`CategoriaKey`),
  ADD CONSTRAINT `hechosventas_ibfk_4` FOREIGN KEY (`ProveedorKey`) REFERENCES `dimproveedores` (`ProveedorKey`),
  ADD CONSTRAINT `hechosventas_ibfk_5` FOREIGN KEY (`TiempoKey`) REFERENCES `dimtiempo` (`TiempoKey`),
  ADD CONSTRAINT `hechosventas_ibfk_6` FOREIGN KEY (`EmpleadoKey`) REFERENCES `dimempleados` (`EmpleadoKey`),
  ADD CONSTRAINT `hechosventas_ibfk_7` FOREIGN KEY (`MetodoKey`) REFERENCES `dimmetodospago` (`MetodoKey`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
