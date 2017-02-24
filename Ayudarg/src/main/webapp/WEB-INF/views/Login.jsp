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
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<html>
<head>
<title>Ayudarg</title>
<script language="javascript">
	function showmydiv() {
		document.getElementById('registrar').style.display = "block";
	}
	function cargarLocalidades(value){
		$.ajax({
			type: "POST",
			data: $("#registrarseForm").serialize(),
			dataType: 'json',
			url: '/app/getLocalidadesByRegristrarse', 
			success: function(data) { 
					var res = data; 
					var options = '';
					options += '<option value="">Seleccione su ciudad</option>';
					$.each(data, function (index, value) {
						options += '<option value="' +value.value + '">' +value.option + '</option>';
					});
					$("select[id=selectLocalidades]").html(options);
// 				}
			},
			error: function(e){ <!-- Si no ha podido conectar con el servidor -->
				alert("Error en el servidor, por favor, intentalo de nuevo mas tarde");
			}
		});
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
				<div class="panel-heading">Bienvenidos a Ayudarg</div>
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
			<c:choose>
				<c:when test="${error.equals(true)}">
					<div class="login-panel panel panel-default" id="registrar"
						style="display: block;">
				</c:when>
				<c:when test="${error.equals(false)}">
					<div class="login-panel panel panel-default" id="registrar"
						style="display: none;">
				</c:when>
			</c:choose>
			<div class="panel-heading">Registrarse</div>
			<div class="panel-body">
				<h4 style="color: red;">${menssage}</h4>
				<form:form id="registrarseForm" method="post"
					action="submitRegistrar" modelAttribute="registrarseBean"
					class="form-signin">
					<label for="inputEmail" class="sr-only">Usuario (*)</label>
					<input type="text" id="usuario" class="form-control"
						placeholder="Nombre de usuario (Campo requerido)" required=""
						autofocus="" name="usuario" value="${usuario}">
					<br>
					<label for="inputPassword" class="sr-only">Contraseña (*)</label>
					<input type="password" id="contrasenia" class="form-control"
						placeholder="Contraseña (Campo requerido)" required=""
						name="contrasenia" value="${contrasenia}">
					<br>
					<label for="inputPassword" class="sr-only">Nombre y
						Apellido (*)</label>
					<input type="text" id="nombre" class="form-control"
						placeholder="Nombre y Apellido (Campo requerido)" required=""
						name="nombre" value="${nombre}">
					<br>
					<label for="inputPassword" class="sr-only">Email (*)</label>
					<input type="email" id="email" class="form-control"
						placeholder="Email (Campo requerido)" required="" name="email"
						value="${email}">
					<br>
					<label for="inputPassword" class="sr-only">Telefono (*)</label>
					<input type="text" id="telefono" class="form-control"
						placeholder="Telefono (Campo requerido)" name="telefono"
						value="${telefono}">
					<br>
					<label for="inputPassword" class="sr-only">Celular</label>
					<input type="text" id="celular" class="form-control"
						placeholder="Celular" required="" name="celular"
						value="${celular}">
					<br>
					<label for="inputPassword" class="sr-only">Fecha de
						Nacimiento (*)</label>
					<input type="date" id="fechaDeNacimiento" class="form-control"
						placeholder="Fecha de Nacimiento (Campo requerido)" required=""
						name="fechaDeNacimiento" value="${fechaDeNacimiento}">
					<br>
					<div class="form-group">
						<form:select path="provincia" required="" multiple="false"
							class="form-control" id='selectProvincias'
							onchange='cargarLocalidades(this.value);'>
							<form:option value="${provincia}" label="Seleccione su Provincia" />
							<form:options items="${provincias}" itemValue="idProvincia"
								itemLabel="provincia" />
						</form:select>
					</div>
					<div class="form-group">
						<form:select path="localidad" required="" multiple="false"
							class="form-control" id="selectLocalidades">
							<form:option value="${localidad}" label="Seleccione su Ciudad" />
							<form:options items="${localidades}" itemValue="localidadesId"
								itemLabel="localidad" />
						</form:select>
					</div>
					<br>
					<div class="col-md-3"></div>
					<div class="col-md-16">
						<button class="btn btn-primary" type="submit" style="width: 100%;">Aceptar</button>
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
</body>
</html>
