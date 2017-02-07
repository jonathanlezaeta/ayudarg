<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/css/datepicker3.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
<html>
<head>
<title>Registrarse</title>
</head>
<body>
	<div class="container">		
        <form:form id="loginForm" method="post" action="dashboard" modelAttribute="UsuarioBean" class="form-signin">
			<h2 class="form-signin-heading" style="text-align: center;">Ayudarg</h2>
			<label for="inputEmail" class="sr-only">Usuario</label> 
			<input type="text" id="usuario" class="form-control" placeholder="Email address" required="" autofocus="" name="usuario"> 
			<label for="inputPassword" class="sr-only">Contraseña</label>
			<input type="password" id="contrasenia" class="form-control" placeholder="Password" required="" name="contrasenia">
			<label for="inputPassword" class="sr-only">Nombre y Apellido</label>
			<input type="password" id="contrasenia" class="form-control" placeholder="Password" required="" name="contrasenia">
			<label for="inputPassword" class="sr-only">Email</label>
			<input type="password" id="contrasenia" class="form-control" placeholder="Password" required="" name="contrasenia">
			<label for="inputPassword" class="sr-only">Telefono</label>
			<input type="password" id="contrasenia" class="form-control" placeholder="Password" required="" name="contrasenia">
			<label for="inputPassword" class="sr-only">Celular</label>
			<input type="password" id="contrasenia" class="form-control" placeholder="Password" required="" name="contrasenia">
			<label for="inputPassword" class="sr-only">Fecha de Nacimiento</label>
			<input type="password" id="contrasenia" class="form-control" placeholder="Password" required="" name="contrasenia">
			<label for="inputPassword" class="sr-only">Ciudad de origen</label>
			<input type="password" id="contrasenia" class="form-control" placeholder="Password" required="" name="contrasenia">
			<button class="btn btn-lg btn-primary btn-block" type="submit">Registrarse</button>
        </form:form>
	</div>
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
