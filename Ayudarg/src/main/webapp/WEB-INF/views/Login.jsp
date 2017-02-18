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
<script language="javascript">
	function showmydiv() {
		document.getElementById('registrar').style.display = "block";
	}
</script>
<style>
body {
	background: transparent url("resources/img/background.jpg") no-repeat;
	background-size: cover;
	padding-top: 15px;
}
</style>
</head>
<body>
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-4">
			<div class="login-panel panel panel-default">
				<div class="panel-heading">Ayudarg</div>
				<div class="panel-body">
					<form:form id="loginForm" method="post" action="dashboard"
						modelAttribute="loginbean" class="form-signin">
						<label for="inputEmail" class="sr-only">Email</label>
						<input type="text" id="usuario" class="form-control"
							placeholder="Email" required="" autofocus="" name="usuario">
						<br>
						<label for="inputPassword" class="sr-only">Contraseña</label>
						<input type="password" id="contrasenia" class="form-control"
							placeholder="Contraseña" required="" name="contrasenia">
						<br>
						<div class="col-md-6">
							<button class="btn btn-primary" type="submit"
								style="width: 100%;">Aceptar</button>
						</div>
						<div class="col-md-6">
							<a href="#" onclick="showmydiv()" class="btn btn-primary"
								style="width: 100%;">Registrarse</a>
						</div>
					</form:form>
				</div>
			</div>

		</div>
		<div class="col-md-6">
			<div class="login-panel panel panel-default" id="registrar"
				style="display: none;">
				<div class="panel-heading">Registrarse</div>
				<div class="panel-body">
					<form:form id="loginForm" method="post" action="dashboard"
						modelAttribute="loginbean" class="form-signin">
						<label for="inputEmail" class="sr-only">Email</label>
						<input type="text" id="usuario" class="form-control"
							placeholder="Email" required="" autofocus="" name="usuario">
						<br>
						<label for="inputPassword" class="sr-only">Contraseña</label>
						<input type="password" id="contrasenia" class="form-control"
							placeholder="Contraseña" required="" name="contrasenia">
						<br>
						<label for="inputPassword" class="sr-only">Nombre y
							apellido</label>
						<input type="password" id="contrasenia" class="form-control"
							placeholder="Nombre y apellido" required="" name="contrasenia">
						<br>
						<label for="inputPassword" class="sr-only">Telefono</label>
						<input type="password" id="contrasenia" class="form-control"
							placeholder="Telefono" required="" name="contrasenia">
						<br>
						<div class="col-md-3"></div>
						<div class="col-md-16">
							<button class="btn btn-primary" type="submit"
								style="width: 100%;">Aceptar</button>
						</div>
						<div class="col-md-3"></div>
					</form:form>
				</div>
			</div>

		</div>
		<div class="col-md-1">
			<!-- /.col-->
		</div>
		<!-- /.row -->



		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/chart.min.js"></script>
		<script src="js/chart-data.js"></script>
		<script src="js/easypiechart.js"></script>
		<script src="js/easypiechart-data.js"></script>
		<script src="js/bootstrap-datepicker.js"></script>
		<script>
			!function($) {
				$(document).on(
						"click",
						"ul.nav li.parent > a > span.icon",
						function() {
							$(this).find('em:first').toggleClass(
									"glyphicon-minus");
						});
				$(".sidebar span.icon").find('em:first').addClass(
						"glyphicon-plus");
			}(window.jQuery);

			$(window).on('resize', function() {
				if ($(window).width() > 768)
					$('#sidebar-collapse').collapse('show')
			})
			$(window).on('resize', function() {
				if ($(window).width() <= 767)
					$('#sidebar-collapse').collapse('hide')
			})
		</script>
</body>
</html>
