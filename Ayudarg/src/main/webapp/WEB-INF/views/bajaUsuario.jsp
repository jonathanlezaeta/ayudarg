<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link href="<c:url value="/resources/css/datepicker3.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<html>
<head>
<title>Usuarios</title>
<script language="javascript">
function cargarLocalidades(value){
	$.ajax({
		type: "POST",
		data: $(value).serialize(),
		dataType: 'json',
		url: '/app/getLocalibadesByIdUsuario', 
		success: function(data) { 
				var res = data; 
				var options = '';
				options += '<option value="">Seleccione su ciudad</option>';
				$.each(data, function (index, value) {
					options += '<option value="' +value.value + '">' +value.option + '</option>';
				});
				$("select[id=selectLocalidades]").html(options);
//				}
		},
		error: function(e){ <!-- Si no ha podido conectar con el servidor -->
			alert("Error en el servidor, por favor, intentalo de nuevo mas tarde");
		}
	});
}

function cargarModificar(value){
	$.ajax({
		type: "POST",
		data: $(value).serialize(),
		dataType: 'json',
		url: '/app/getUsuariosById', 
		success: function(data) { 
				var res = data; 
				var options = '';
				options += '<option value="">Seleccione su ciudad</option>';
				$.each(data, function (index, value) {
					options += '<option value="' +value.value + '">' +value.option + '</option>';
				});
				$("select[id=selectLocalidades]").html(options);
//				}
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
	padding-top: 35px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#sidebar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><span>AYUD</span>ARG</a>
			<ul class="user-menu">
				<!-- 					<li class="dropdown pull-right"> -->
				<!-- 						<a href="#" class="dropdown-toggle" data-toggle="dropdown"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> User <span class="caret"></span></a> -->
				<!-- 						<ul class="dropdown-menu" role="menu"> -->
				<!-- 							<li><a href="#"><svg class="glyph stroked male-user"><use xlink:href="#stroked-male-user"></use></svg> Profile</a></li> -->
				<!-- 							<li><a href="#"><svg class="glyph stroked gear"><use xlink:href="#stroked-gear"></use></svg> Settings</a></li> -->
				<!-- 							<li><a href="#"><svg class="glyph stroked cancel"><use xlink:href="#stroked-cancel"></use></svg> Logout</a></li> -->
				<!-- 						</ul> -->
				<!-- 					</li> -->
			</ul>
		</div>

	</div>
	<!-- /.container-fluid --> </nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<c:choose>
			<c:when test="${rol.equals('A')}">
				<ul class="nav menu">
					<li><a href="/app/dashboard"><svg
								class="glyph stroked dashboard-dial"> <use
								xlink:href="/dashboard"></use></svg> Inicio</a></li>
					<li><a href="/app/donar"><svg
								class="glyph stroked calendar"> <use xlink:href="/donar"></use></svg>
							Donar</a></li>
					<li><a href="/app/demandar"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/demandar"></use></svg> Demandar</a></li>
					<li><a href="/app/altaInstitucion"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/altaInstitucion"></use></svg> Instituciones</a></li>
					<li><a href="/app/altaCategoria"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/altaCategoria"></use></svg> Categorias</a></li>
					<li><a href="/app/bajaUsuario"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/bajaUsuario"></use></svg> Usuarios</a></li>
				</ul>
			</c:when>
			<c:when test="${rol.equals('U')}">
				<ul class="nav menu">
					<li><a href="/app/dashboard"><svg
								class="glyph stroked dashboard-dial"> <use
								xlink:href="/dashboard"></use></svg> Inicio</a></li>
					<li><a href="/app/donar"><svg
								class="glyph stroked calendar"> <use xlink:href="/donar"></use></svg>
							Donar</a></li>
					<li><a href="/app/demandar"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/demandar"></use></svg>Solicitar un recurso</a></li>
				</ul>
			</c:when>
			<c:when test="${rol.equals('I')}">
				<ul class="nav menu">
					<li><a href="/app/dashboard"><svg
								class="glyph stroked dashboard-dial"> <use
								xlink:href="/dashboard"></use></svg> Inicio</a></li>
					<li><a href="/app/donar"><svg
								class="glyph stroked calendar"> <use xlink:href="/donar"></use></svg>
							Donar</a></li>
					<li><a href="/app/demandar"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/demandar"></use></svg> Demandar</a></li>
					<li><a href="/app/altaInstitucion"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/altaInstitucion"></use></svg> Instituciones</a></li>
					<li><a href="/app/altaCategoria"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/altaCategoria"></use></svg> Categorias</a></li>
					<li><a href="/app/bajaUsuario"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/bajaUsuario"></use></svg> Usuarios</a></li>
				</ul>
			</c:when>
		</c:choose>
	</div>
	<!--/.sidebar-->
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<svg class="glyph stroked email"> <use
							xlink:href="#stroked-email"></use></svg>
						Usuario
					</div>
					<div class="panel-body">

						<div class="container">
							<div id="exTab2" class="col-md-10">
								<ul class="nav nav-tabs">
									<li class="active">
									<a href="#1" data-toggle="tab">Registar</a></li>
									<li><a href="#2" data-toggle="tab">Eliminar</a></li>
									<li><a href="#3" data-toggle="tab">Modificar</a></li>
									<li><a href="#4" data-toggle="tab">Asignar Institucion</a></li>
								</ul>


								<div class="tab-content ">
									<div class="tab-pane active" id="1">
										<form:form id="usuarioForm" method="post"
											action="submitAltaUsuario" modelAttribute="usuarioBean"
											class="form-signin">
											<fieldset>

												<!-- Nombre input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="nombre">Usuario</label>
													<div class="col-md-9">
														<input type="text" id="usuario" class="form-control"
															placeholder="Ingrese un Nombre de Usuario" required=""
															autofocus="" name="usuario">
													</div>
												</div>

												<!-- Contraseña input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="contrasenia">Contraseña</label>
													<div class="col-md-9">
														<input id="contrasenia" name="contrasenia" type="password"
															placeholder="Ingrese contraseña" class="form-control" required="">
													</div>
												</div>

												<!-- Nombre input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="nombre">Nombre</label>
													<div class="col-md-9">
														<input id="nombre" name="nombre" type="text"
															placeholder="Ingrese nombre" class="form-control" required="">
													</div>
												</div>

												<!-- Email input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="email">Email</label>
													<div class="col-md-9">
														<input id="email" name="email" type="email"
															placeholder="Ingrese email" class="form-control" required="">
													</div>
												</div>

												<!-- Telefono input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="telefono">Telefono</label>
													<div class="col-md-9">
														<input id="telefono" name="telefono" type="text"
															placeholder="Ingrese telefono" class="form-control" required="">
													</div>
												</div>

												<!-- Celular input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="celular">Celular</label>
													<div class="col-md-9">
														<input id="celular" name="celular" type="text"
															placeholder="Ingrese celular" class="form-control">
													</div>
												</div>

												<!-- Fecha Nacimiento input-->
												<div class="form-group">
													<label class="col-md-3 control-label"
														for="fechaDeNacimiento">Fecha de nacimiento</label>
													<div class="col-md-9">
														<input id="fechaDeNacimiento" name="fechaDeNacimiento"
															type="date" placeholder="Ingrese fecha de nacimiento"
															class="form-control" required="">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Provincias</label>
													<div class="col-md-9">
														<form:select path="provincia" required="" multiple="false"
															class="form-control" id='selectProvincias'
															onchange='cargarLocalidades("#usuarioForm");'>
															<form:option value="NONE" label="Seleccione su provincia" />
															<form:options items="${provincias}"
																itemValue="idProvincia" itemLabel="provincia" />
														</form:select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Localidades</label>
													<div class="col-md-9">
														<form:select path="localidad" required="" multiple="false"
															class="form-control" id="selectLocalidades">
															<form:options items="${localidades}"
																itemValue="localidadesId" itemLabel="localidad" />
														</form:select>
													</div>
												</div>

												<!-- Form actions -->
												<div class="form-group">
													<div class="col-md-12 widget-right">
														<button type="submit"
															class="btn btn-default btn-md pull-right">Registrar</button>
													</div>
												</div>
											</fieldset>
										</form:form>
									</div>


									<div class="tab-pane" id="2">
										<form:form id="usuarioBajaForm" method="post"
											action="submitBajaUsuario" modelAttribute="usuarioBajaBean"
											class="form-signin">
											<fieldset>

												<!-- SubCategoria input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Usuario</label>
													<div class="col-md-9">
														<form:select path="idUsuario" multiple="false"
															class="form-control">
															<form:options items="${usuario}" itemValue="idUsuario"
																itemLabel="nombre" />
														</form:select>
													</div>
												</div>


												<!-- Form actions -->
												<div class="form-group">
													<div class="col-md-12 widget-right">
														<button type="submit"
															class="btn btn-default btn-md pull-right">Eliminar</button>
													</div>
												</div>
											</fieldset>
										</form:form>
									</div>

									<div class="tab-pane" id="3">
										<form:form id="modificarUsuario" method="post"
											action="submitUpdateUsuario" modelAttribute="usuarioBean"
											class="form-signin">
											<fieldset>


												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Usuario
														a modificar</label>
													<div class="col-md-9">
														<form:select path="idUsuario" required="" multiple="false"
															class="form-control"
															onchange='cargarModificar("#modificarUsuario");'>
															<form:option value="NONE" label="Seleccione..." />
															<form:options items="${usuario}" itemValue="idUsuario" required=""
																itemLabel="nombre" />
														</form:select>
													</div>
												</div>

												<!-- Contraseña input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="contrasenia">Contraseña</label>
													<div class="col-md-9">
														<input id="contrasenia" name="contrasenia" type="password" required=""
															placeholder="Ingrese nueva contraseña"
															class="form-control">
													</div>
												</div>

												<!-- Nombre input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="nombre">Nombre</label>
													<div class="col-md-9">
														<input id="nombre" name="nombre" type="text" required=""
															placeholder="Ingrese nuevo nombre" class="form-control">
													</div>
												</div>

												<!-- Email input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="email">Email</label>
													<div class="col-md-9">
														<input id="email" name="email" type="email" required=""
															placeholder="Ingrese nuevo email" class="form-control">
													</div>
												</div>

												<!-- Telefono input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="telefono">Telefono</label>
													<div class="col-md-9">
														<input id="telefono" name="telefono" type="text" required=""
															placeholder="Ingrese nuevo telefono" class="form-control">
													</div>
												</div>

												<!-- Celular input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="celular">Celular</label>
													<div class="col-md-9">
														<input id="celular" name="celular" type="text"
															placeholder="Ingrese nuevo celular" class="form-control">
													</div>
												</div>

												<!-- Fecha Nacimiento input-->
												<div class="form-group">
													<label class="col-md-3 control-label"
														for="fechaDeNacimiento">Fecha de nacimiento</label>
													<div class="col-md-9">
														<input id="fechaDeNacimiento" name="fechaDeNacimiento"
															type="date" required=""
															placeholder="Ingrese nueva fecha de nacimiento"
															class="form-control">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Provincias</label>
													<div class="col-md-9">
														<form:select path="provincia" required="" multiple="false"
															class="form-control" id='selectProvincias'
															onchange='cargarLocalidades("#usuarioForm");'>
															<form:option value="NONE" label="Seleccione su provincia" />
															<form:options items="${provincias}"
																itemValue="idProvincia" itemLabel="provincia" />
														</form:select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Localidades</label>
													<div class="col-md-9">
														<form:select path="localidad" required="" multiple="false"
															class="form-control" id="selectLocalidades">
															<form:options items="${localidades}"
																itemValue="localidadesId" itemLabel="localidad" />
														</form:select>
													</div>
												</div>

												<!-- Form actions -->
												<div class="form-group">
													<div class="col-md-12 widget-right">
														<button type="submit"
															class="btn btn-default btn-md pull-right">Modificar</button>
													</div>
												</div>
											</fieldset>
										</form:form>
									</div>
											
											
									<div class="tab-pane" id="4">
										<form:form id="asignarForm" method="post"
											action="submitAsignarInstitucion"
											modelAttribute="asignarBean" class="form-signin">
											<fieldset>
											
					


												<!-- Form actions -->
												<div class="form-group">
													<div class="col-md-12 widget-right">
														<button type="submit"
															class="btn btn-default btn-md pull-right">Asignar</button>
													</div>
												</div>
											</fieldset>
										</form:form>
									</div>
											
											
											
											
											
											
											
								</div>		
							</div>
						</div>
						<script
							src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
						<script
							src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
					</div>
				</div>
</body>
</html>