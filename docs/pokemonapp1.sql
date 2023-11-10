-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: database:3306
-- Tiempo de generación: 10-11-2023 a las 08:56:49
-- Versión del servidor: 8.1.0
-- Versión de PHP: 8.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pokemonapp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrenador`
--

CREATE TABLE `entrenador` (
  `id` int NOT NULL,
  `email` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `entrenador`
--

INSERT INTO `entrenador` (`id`, `email`, `username`, `password`, `role`) VALUES
(1, 'pablo@mail.com', 'pablomolero', 'hola', b'0'),
(2, 'hola@prueba.com', 'prueba1', 'hola', b'0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--

CREATE TABLE `equipo` (
  `id` int NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` text NOT NULL,
  `entrenador_id` int DEFAULT NULL,
  `id_entrenador` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`id`, `nombre`, `descripcion`, `entrenador_id`, `id_entrenador`) VALUES
(1, 'Monotype Eléctrico', 'Equipo de 6 pokémon del mismo tipo, el eléctrico.', 1, NULL),
(2, 'Equipo Prueba', 'prueba1', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo_pokemon`
--

CREATE TABLE `equipo_pokemon` (
  `id` bigint NOT NULL,
  `equipo_id` int NOT NULL,
  `pokemon_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `equipo_pokemon`
--

INSERT INTO `equipo_pokemon` (`id`, `equipo_id`, `pokemon_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 1, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon`
--

CREATE TABLE `pokemon` (
  `id` int NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `tipo1` varchar(255) NOT NULL,
  `tipo2` varchar(255) DEFAULT NULL,
  `ataque1` varchar(255) NOT NULL,
  `ataque2` varchar(255) DEFAULT NULL,
  `ataque3` varchar(255) DEFAULT NULL,
  `ataque4` varchar(255) DEFAULT NULL,
  `generacion` int NOT NULL,
  `ataque` int NOT NULL,
  `defensa` int NOT NULL,
  `velocidad` int NOT NULL,
  `salud` int NOT NULL,
  `defensa_especial` int NOT NULL,
  `ataque_especial` int NOT NULL,
  `objeto` varchar(255) DEFAULT NULL,
  `habilidad` varchar(255) NOT NULL,
  `naturaleza` varchar(255) NOT NULL,
  `nivel` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `pokemon`
--

INSERT INTO `pokemon` (`id`, `nombre`, `tipo1`, `tipo2`, `ataque1`, `ataque2`, `ataque3`, `ataque4`, `generacion`, `ataque`, `defensa`, `velocidad`, `salud`, `defensa_especial`, `ataque_especial`, `objeto`, `habilidad`, `naturaleza`, `nivel`) VALUES
(1, 'Galvantula', 'Eléctrico', 'Bicho', 'Red Viscosa', 'Trueno', 'Zumbido', 'Voltiocambio', 5, 171, 156, 346, 281, 157, 293, 'Banda Focus', 'Ojo Compuesto', 'Miedosa', 100),
(2, 'Sandshrew', 'tierra', NULL, 'placaje', NULL, NULL, NULL, 1, 139, 157, 76, 210, 0, 0, NULL, 'velo arena', 'firme', 100),
(3, 'Joltik', 'Eléctrico', 'Bicho', 'Red Viscosa', 'Impactrueno', NULL, NULL, 5, 101, 86, 286, 191, 87, 213, 'Banda Focus', 'Ojo Compuesto', 'Miedosa', 100);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_entrenador` (`entrenador_id`);

--
-- Indices de la tabla `equipo_pokemon`
--
ALTER TABLE `equipo_pokemon`
  ADD PRIMARY KEY (`id`),
  ADD KEY `equipo_id` (`equipo_id`),
  ADD KEY `pokemon_id` (`pokemon_id`);

--
-- Indices de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `entrenador`
--
ALTER TABLE `entrenador`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `equipo`
--
ALTER TABLE `equipo`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `equipo_pokemon`
--
ALTER TABLE `equipo_pokemon`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `fk_entrenador` FOREIGN KEY (`entrenador_id`) REFERENCES `entrenador` (`id`);

--
-- Filtros para la tabla `equipo_pokemon`
--
ALTER TABLE `equipo_pokemon`
  ADD CONSTRAINT `equipo_pokemon_ibfk_1` FOREIGN KEY (`equipo_id`) REFERENCES `equipo` (`id`),
  ADD CONSTRAINT `equipo_pokemon_ibfk_2` FOREIGN KEY (`pokemon_id`) REFERENCES `pokemon` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
