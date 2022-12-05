<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Página Principal</title>
</head>
<body>

	<header>
		<h1>AE3 - Spring Data JPA: Cajero Virtual</h1>
	</header>
	
	<!-- Página que muestra la lista de operaciones que puedes hacer. -->
	
	<main>
	
		<h3>Número de Cuenta: ${ cuenta.idCuenta }.</h3>
		<h3>Saldo: ${ cuenta.saldo } euros.</h3>
		<h2>¿Que operación quieres realizar?</h2>
		
		<ul>
			<li><a href="/ingresar">Ingresar Dinero.</a></li>
			<li><a href="/retirar">Extraer Dinero.</a></li>
			<li><a href="/movimientos">Ver los Movimientos.</a></li>
			<li><a href="/transferencia">Hace una Transferencia.</a></li>
			<li><a href="/">Cambiar de Cuenta.</a></li>
		</ul>
		
	</main>
	
	<footer>
		<h6>©Pavlo Dundyk | Tarea tres para DWES</h6>
	</footer>
	
</body>
</html>