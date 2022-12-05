<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inicio - Login</title>
</head>
<body>

	<header>
	<h1>AE3 - Spring Data JPA: Cajero Virtual</h1>
	</header>
	
	<!-- Página para identificarse -->
	
	<main>
		<h2>Identificación</h2>
		<form action="/identificacion" method="get">
			<label for="idCuenta">Número de Cuenta:</label>
			<input type="text" id="idCuenta" name="idCuenta"/>
			<button type="submit">Entrar</button>
		</form>
		<p style="color: red;">${ errorIniciarSesion }</p>
	</main>
	
	<footer>
		<h6>©Pavlo Dundyk | Tarea tres para DWES</h6>
	</footer>

</body>
</html>