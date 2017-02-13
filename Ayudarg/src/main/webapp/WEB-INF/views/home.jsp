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
<title>Ayudarg</title>
</head>
<body>
	<div class="container"
		style="width: 275px; margin-left: auto; margin-rigth: auto; margin-top: 50px;">
        <form:form id="loginForm" method="post" action="dashboard" modelAttribute="loginbean" class="form-signin">
			<h2 class="form-signin-heading" style="text-align: center;">Ayudarg</h2>
			<label for="inputEmail" class="sr-only">Email</label> <input
				type="text" id="usuario" class="form-control"
				placeholder="Email" required="" autofocus="" name="usuario"> 
				<label
				for="inputPassword" class="sr-only">Contraseña</label> <input
				type="password" id="contrasenia" class="form-control"
				placeholder="Contraseña" required="" name="contrasenia">
			<a href="/app/registrarse">Registrarse</a>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
        </form:form>

	</div>
	<!-- /container -->
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>


</body>
</html>
