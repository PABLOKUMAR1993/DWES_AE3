<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transferencia</title>
</head>
<body>

	<header>
	<h1>AE3 - Spring Data JPA: Cajero Virtual</h1>
	</header>
	
	<!-- Página para hacer una transferencia entre dos cuentas. -->
	
	<main>
		<h3>Número de Cuenta: ${ cuenta.idCuenta }.</h3>
		<h3>Saldo: ${ cuenta.saldo } euros.</h3>
		<h2>Transferencia.</h2>
		
		<form action="/transferir" method="post">
			<label for="cantidad">Introduce la Cantidad:</label>
			<input type="number" id="cantidad" name="cantidad"/>
			<label for="idCuenta">Introduce la cuenta destino:</label>
			<input type="number" id="idCuenta" name="idCuenta"/>
			<button type="submit">Enviar Dinero</button>
		</form>
		
		<p style="color: green">${ mensajeExitoTransferencia }</p>
		<p style="color: red">${ mensajeErrorTransferencia }</p>
		
		<a href="/menu">Volver al menú.</a>
	</main>
	
	<footer>
	<h6>©Pavlo Dundyk | Tarea tres para DWES</h6>
	</footer>
	
</body>
</html>