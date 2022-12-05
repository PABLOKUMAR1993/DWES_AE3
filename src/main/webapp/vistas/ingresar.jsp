<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ingreso</title>
</head>
<body>

	<header>
	<h1>AE3 - Spring Data JPA: Cajero Virtual</h1>
	</header>
	
	<!-- Página para mostrar la opción de ingresar dinero -->
	
	<main>
		<h3>Número de Cuenta: ${ cuenta.idCuenta }.</h3>
		<h3>Saldo: ${ cuenta.saldo } euros.</h3>
		<h2>Ingreso de Dinero.</h2>
		
		<form action="/ingreso" method="post">
			<label for="cantidad">Cantidad:</label>
			<input type="number" id="cantidad" name="cantidad"/>
			<button type="submit">Ingresar</button>
		</form>
		
		<p style="color: green;">${ mensajeIngreso }</p>
		<p style="color: red;">${ mensajeErrorIngreso }</p>
		<a href="/menu">Volver al menú.</a>
	</main>
	
	<footer>
	<h6>©Pavlo Dundyk | Tarea tres para DWES</h6>
	</footer>

</body>
</html>