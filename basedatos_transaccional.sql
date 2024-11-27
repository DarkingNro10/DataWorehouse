-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Nov 27, 2024 at 08:03 AM
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
-- Database: `basedatos_transaccional`
--

-- --------------------------------------------------------

--
-- Table structure for table `categorias`
--

CREATE TABLE `categorias` (
  `CategoriaID` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `categorias`
--

INSERT INTO `categorias` (`CategoriaID`, `Nombre`) VALUES
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
-- Table structure for table `clientes`
--

CREATE TABLE `clientes` (
  `ClienteID` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Direccion` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `clientes`
--

INSERT INTO `clientes` (`ClienteID`, `Nombre`, `Email`, `Telefono`, `Direccion`) VALUES
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
-- Table structure for table `detalleventas`
--

CREATE TABLE `detalleventas` (
  `DetalleID` int NOT NULL,
  `VentaID` int DEFAULT NULL,
  `ProductoID` int DEFAULT NULL,
  `Cantidad` int DEFAULT NULL,
  `PrecioUnitario` decimal(10,2) DEFAULT NULL,
  `Subtotal` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `detalleventas`
--

INSERT INTO `detalleventas` (`DetalleID`, `VentaID`, `ProductoID`, `Cantidad`, `PrecioUnitario`, `Subtotal`) VALUES
(1, 1, 1, 1, '1500.00', '1500.00'),
(2, 2, 2, 1, '800.00', '800.00'),
(3, 3, 3, 2, '50.00', '100.00'),
(4, 4, 4, 1, '300.00', '300.00'),
(5, 5, 5, 3, '25.00', '75.00'),
(6, 6, 6, 1, '200.00', '200.00'),
(7, 7, 7, 1, '100.00', '100.00'),
(8, 8, 8, 1, '400.00', '400.00'),
(9, 9, 9, 1, '600.00', '600.00'),
(10, 10, 10, 2, '150.00', '300.00');

-- --------------------------------------------------------

--
-- Table structure for table `devoluciones`
--

CREATE TABLE `devoluciones` (
  `DevolucionID` int NOT NULL,
  `VentaID` int DEFAULT NULL,
  `ProductoID` int DEFAULT NULL,
  `Cantidad` int DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Motivo` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `devoluciones`
--

INSERT INTO `devoluciones` (`DevolucionID`, `VentaID`, `ProductoID`, `Cantidad`, `Fecha`, `Motivo`) VALUES
(1, 1, 1, 1, '2024-11-15', 'Producto defectuoso'),
(2, 2, 2, 1, '2024-11-16', 'Error en el pedido'),
(3, 3, 3, 1, '2024-11-17', 'No cumplió expectativas'),
(4, 4, 4, 1, '2024-11-18', 'Daño en el envío'),
(5, 5, 5, 1, '2024-11-19', 'Cliente cambió de opinión'),
(6, 6, 6, 1, '2024-11-20', 'Producto incompleto'),
(7, 7, 7, 1, '2024-11-21', 'Fallo técnico'),
(8, 8, 8, 1, '2024-11-22', 'Otro motivo'),
(9, 9, 9, 1, '2024-11-23', 'Reclamación del cliente'),
(10, 10, 10, 1, '2024-11-24', 'Producto no compatible');

-- --------------------------------------------------------

--
-- Table structure for table `empleados`
--

CREATE TABLE `empleados` (
  `EmpleadoID` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Puesto` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `empleados`
--

INSERT INTO `empleados` (`EmpleadoID`, `Nombre`, `Puesto`) VALUES
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
-- Table structure for table `inventario`
--

CREATE TABLE `inventario` (
  `InventarioID` int NOT NULL,
  `ProductoID` int DEFAULT NULL,
  `ProveedorID` int DEFAULT NULL,
  `Cantidad` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `inventario`
--

INSERT INTO `inventario` (`InventarioID`, `ProductoID`, `ProveedorID`, `Cantidad`) VALUES
(1, 1, 1, 50),
(2, 2, 2, 100),
(3, 3, 3, 200),
(4, 4, 1, 75),
(5, 5, 5, 150),
(6, 6, 6, 30),
(7, 7, 7, 80),
(8, 8, 8, 60),
(9, 9, 9, 40),
(10, 10, 10, 120);

-- --------------------------------------------------------

--
-- Table structure for table `metodospago`
--

CREATE TABLE `metodospago` (
  `MetodoID` int NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `metodospago`
--

INSERT INTO `metodospago` (`MetodoID`, `Descripcion`) VALUES
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
-- Table structure for table `productos`
--

CREATE TABLE `productos` (
  `ProductoID` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Precio` decimal(10,2) DEFAULT NULL,
  `CategoriaID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `productos`
--

INSERT INTO `productos` (`ProductoID`, `Nombre`, `Precio`, `CategoriaID`) VALUES
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
-- Table structure for table `proveedores`
--

CREATE TABLE `proveedores` (
  `ProveedorID` int NOT NULL,
  `Nombre` varchar(100) DEFAULT NULL,
  `Contacto` varchar(100) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `proveedores`
--

INSERT INTO `proveedores` (`ProveedorID`, `Nombre`, `Contacto`, `Telefono`) VALUES
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
-- Table structure for table `ventas`
--

CREATE TABLE `ventas` (
  `VentaID` int NOT NULL,
  `ClienteID` int DEFAULT NULL,
  `EmpleadoID` int DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `MetodoID` int DEFAULT NULL,
  `Total` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `ventas`
--

INSERT INTO `ventas` (`VentaID`, `ClienteID`, `EmpleadoID`, `Fecha`, `MetodoID`, `Total`) VALUES
(1, 1, 1, '2024-11-01', 2, '1500.00'),
(2, 2, 2, '2024-11-02', 3, '800.00'),
(3, 3, 3, '2024-11-03', 1, '100.00'),
(4, 4, 4, '2024-11-04', 4, '300.00'),
(5, 5, 5, '2024-11-05', 2, '75.00'),
(6, 6, 6, '2024-11-06', 3, '200.00'),
(7, 7, 7, '2024-11-07', 5, '100.00'),
(8, 8, 8, '2024-11-08', 1, '400.00'),
(9, 9, 9, '2024-11-09', 4, '600.00'),
(10, 10, 10, '2024-11-10', 2, '300.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`CategoriaID`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`ClienteID`);

--
-- Indexes for table `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD PRIMARY KEY (`DetalleID`),
  ADD KEY `VentaID` (`VentaID`),
  ADD KEY `ProductoID` (`ProductoID`);

--
-- Indexes for table `devoluciones`
--
ALTER TABLE `devoluciones`
  ADD PRIMARY KEY (`DevolucionID`),
  ADD KEY `VentaID` (`VentaID`),
  ADD KEY `ProductoID` (`ProductoID`);

--
-- Indexes for table `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`EmpleadoID`);

--
-- Indexes for table `inventario`
--
ALTER TABLE `inventario`
  ADD PRIMARY KEY (`InventarioID`),
  ADD KEY `ProductoID` (`ProductoID`),
  ADD KEY `ProveedorID` (`ProveedorID`);

--
-- Indexes for table `metodospago`
--
ALTER TABLE `metodospago`
  ADD PRIMARY KEY (`MetodoID`);

--
-- Indexes for table `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`ProductoID`),
  ADD KEY `CategoriaID` (`CategoriaID`);

--
-- Indexes for table `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`ProveedorID`);

--
-- Indexes for table `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`VentaID`),
  ADD KEY `ClienteID` (`ClienteID`),
  ADD KEY `EmpleadoID` (`EmpleadoID`),
  ADD KEY `MetodoID` (`MetodoID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `detalleventas`
--
ALTER TABLE `detalleventas`
  ADD CONSTRAINT `detalleventas_ibfk_1` FOREIGN KEY (`VentaID`) REFERENCES `ventas` (`VentaID`),
  ADD CONSTRAINT `detalleventas_ibfk_2` FOREIGN KEY (`ProductoID`) REFERENCES `productos` (`ProductoID`);

--
-- Constraints for table `devoluciones`
--
ALTER TABLE `devoluciones`
  ADD CONSTRAINT `devoluciones_ibfk_1` FOREIGN KEY (`VentaID`) REFERENCES `ventas` (`VentaID`),
  ADD CONSTRAINT `devoluciones_ibfk_2` FOREIGN KEY (`ProductoID`) REFERENCES `productos` (`ProductoID`);

--
-- Constraints for table `inventario`
--
ALTER TABLE `inventario`
  ADD CONSTRAINT `inventario_ibfk_1` FOREIGN KEY (`ProductoID`) REFERENCES `productos` (`ProductoID`),
  ADD CONSTRAINT `inventario_ibfk_2` FOREIGN KEY (`ProveedorID`) REFERENCES `proveedores` (`ProveedorID`);

--
-- Constraints for table `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`CategoriaID`) REFERENCES `categorias` (`CategoriaID`);

--
-- Constraints for table `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`ClienteID`) REFERENCES `clientes` (`ClienteID`),
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`EmpleadoID`) REFERENCES `empleados` (`EmpleadoID`),
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`MetodoID`) REFERENCES `metodospago` (`MetodoID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
