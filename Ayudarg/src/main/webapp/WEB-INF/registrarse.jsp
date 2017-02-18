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
	<div class="row">
  		<div class="col-md-6 col-md-offset-3">
	        <form:form id="registrarseForm" method="post" action="submitRegistrar" modelAttribute="usuarioBean" class="form-signin">
				<h2 class="form-signin-heading" style="text-align: center;">Ayudarg</h2>
				<label for="inputEmail" class="sr-only">Usuario</label> 
				<input type="text" id="usuario" class="form-control" placeholder="Ingrese un Nombre de Usuario" required="" autofocus="" name="usuario"> 
				<br>
				<label for="inputPassword" class="sr-only">Contraseña</label>
				<input type="password" id="contrasenia" class="form-control" placeholder="Contraseña" required="" name="contrasenia">
				<br>
				<label for="inputPassword" class="sr-only">Nombre y Apellido</label>
				<input type="text" id="nombre" class="form-control" placeholder="Nombre y Apellido" required="" name="nombre">
				<br>
				<label for="inputPassword" class="sr-only">Email</label>
				<input type="email" id="email" class="form-control" placeholder="Email" required="" name="email">
				<br>
				<label for="inputPassword" class="sr-only">Telefono</label>
				<input type="text" id="telefono" class="form-control" placeholder="Telefono" required="" name="telefono">
				<br>
				<label for="inputPassword" class="sr-only">Celular</label>
				<input type="text" id="celular" class="form-control" placeholder="Celular" required="" name="celular">
				<br>
				<label for="inputPassword" class="sr-only">Fecha de Nacimiento</label>
				<input type="date" id="fechaDeNacimiento" class="form-control" placeholder="Fecha de Nacimiento" required="" name="fechaDeNacimiento" >
				<br>
				<label for="inputPassword" class="sr-only">Ciudad de origen</label>
				<input type="text" id="ciudadOrigen" class="form-control" placeholder="Ciudad de Origen" required="" name="ciudadOrigen">
				<br>
				<button class="btn btn-lg btn-primary btn-block" style="width:50%; margin-left:auto; margin-right:auto;" type="submit">Aceptar</button>
	        </form:form>
        </div>
	</div>
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
