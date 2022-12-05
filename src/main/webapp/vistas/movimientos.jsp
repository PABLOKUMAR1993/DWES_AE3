<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movimientos</title>
</head>
<body>

	<c:set value="ingreso" var="ingreso" />
	<c:set value="retirada" var="retirada" />

	<header>
		<h1>AE3 - Spring Data JPA: Cajero Virtual</h1>
	</header>
	
	<!-- Página para mostrar un listado de movimientos -->
	
	<main>
		<h3>Número de Cuenta: ${ cuenta.idCuenta }.</h3>
		<h3>Saldo: ${ cuenta.saldo } euros.</h3>
		<h2>Listado de Movimientos.</h2>
		
		<table>
			<thead>
				<tr>
					<th>CANTIDAD</th>
					<th>FECHA</th>
					<th>TIPO</th>
				</tr>
			</thead>
			<tbody>
			
			<!-- meto una condición, para que según si es retirada o ingreso pintarlo de color rojo o verde. -->
			
			<c:forEach var="movimiento" items="${ listadoMovimientos }">
				<c:if test="${ movimiento.operacion == ingreso }">
					<tr style="color: green;">
						<td>${ movimiento.cantidad } euros</td>
						<td>${ movimiento.fecha }</td>
						<td>${ movimiento.operacion }</td>
					</tr>
				</c:if>
				<c:if test="${ movimiento.operacion == retirada }">
					<tr style="color: red;">
						<td>${ movimiento.cantidad } euros</td>
						<td>${ movimiento.fecha }</td>
						<td>${ movimiento.operacion }</td>
					</tr>
				</c:if>
			</c:forEach>
			</tbody>
		</table>
		
		<a href="/menu">Volver al menú.</a>
	</main>
	
	<footer>
		<h6>©Pavlo Dundyk | Tarea tres para DWES</h6>
	</footer>

</body>
</html>