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
0
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<html>
<head>
<title>Instituciones</title>
<script language="javascript">
	function cargarLocalidades(value){
		$.ajax({
			type: "POST",
			data: $(value).serialize(),
			dataType: 'json',
			url: '/app/getLocalibadesByIdInstitucion', 
			success: function(data) { 
					var res = data; 
					var options = '';
					options += '<option value="">Seleccione su ciudad</option>';
					$.each(data, function (index, value) {
						options += '<option value="' +value.value + '">' +value.option + '</option>';
					});
					$("select[id=selectLocalidades]").html(options);
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
			url: '/app/getInstitucionById', 
			success: function(data) { 
				var res = data; 
				document.getElementById("directorModificar").value= res.director;
				document.getElementById("tipoModificar").value= res.tipo;
				document.getElementById("nombreModificar").value= res.nombre;
				document.getElementById("direccionModificar").value= res.direccion;
				document.getElementById("telefonoModificar").value= res.telefono;
				document.getElementById("sitioWebModificar").value= res.sitioWeb;
				document.getElementById("emailModificar").value= res.email;
				$('#selectLocalidadesModificar').val(res.localidad); 
				document.getElementById("celularModificar").value= res.celular;
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
								xlink:href="/demandar"></use></svg> Solicitar un recurso</a></li>
					<li><a href="/app/altaInstitucion"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/altaInstitucion"></use></svg> Instituciones</a></li>
					<li><a href="/app/altaCategoria"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="/altaCategoria"></use></svg> Categorias</a></li>
					<li><a href="/app/bajaUsuario"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="recurso"></use></svg> Usuarios</a></li>

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
								xlink:href="/demandar"></use></svg> Solicitar un recurso</a></li>
					<li><a href="/app/recurso"><svg
								class="glyph stroked line-graph"> <use
								xlink:href="recurso"></use></svg> Recursos</a></li>
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
						Instituciones
					</div>
					<div class="panel-body">
						<h4 style="color: red;">${menssage}</h4>

						<div class="col-md-12">
							<h4 style="color: red;">${errorRegistrar}</h4>
						</div>

						<div class="container" style="width: 100%;">
							<div id="exTab2" class="col-md-12">
								<ul class="nav nav-tabs">
									<li class="active"><a href="#1" data-toggle="tab">Registar</a>
									</li>
									<li><a href="#2" data-toggle="tab">Eliminar</a></li>
									<li><a href="#3" data-toggle="tab">Modificar</a></li>
								</ul>

								<div class="tab-content ">
									<div class="tab-pane active" id="1">
										<form:form id="institucionForm" method="post"
											action="submitAltaInstitucion"
											modelAttribute="institucionBean" class="form-signin">
											<fieldset>

												<!-- Director input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="director">Director</label>
													<div class="col-md-9">
														<input id="director" name="director" type="text" maxlength="40"
															placeholder="Ingrese director de la Institucion (Campo requerido)"
															class="form-control" required="" value="${director}">
													</div>
												</div>

												<!-- Tipo input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="tipo">Tipo</label>
													<div class="col-md-9">
														<input id="tipo" name="tipo" type="text" maxlength="40"
															placeholder="Ingrese tipo de Institucion (Campo requerido)"
															class="form-control" required="" value="${tipo}">
													</div>
												</div>

												<!-- Nombre input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="nombre">Nombre</label>
													<div class="col-md-9">
														<input id="nombre" name="nombre" type="text" maxlength="40"
															placeholder="Ingrese nombre de la Institucion (Campo requerido)"
															class="form-control" required="" value="${nombre}">
													</div>
												</div>

												<!-- Direccion input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="direccion">Direccion</label>
													<div class="col-md-9">
														<input id="direccion" name="direccion" type="text" maxlength="40"
															placeholder="Ingrese direccion de la Institucion (Campo requerido)"
															class="form-control" required="" value="${direccion}">
													</div>
												</div>

												<!-- Telefono input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="telefono">Telefono</label>
													<div class="col-md-9">
														<input id="telefono" name="telefono" type="text" maxlength="40"
															placeholder="Ingrese telefono de la Institucion (Campo requerido)"
															class="form-control" required="" value="${telefono}">
													</div>
												</div>

												<!-- Celular input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="celular">Celular</label>
													<div class="col-md-9">
														<input id="celular" name="celular" type="text" maxlength="40"
															placeholder="Ingrese celular de la Institucion"
															class="form-control" value="${celular}">
													</div>
												</div>

												<!-- SitioWeb input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="sitioWeb">Sitio
														Web</label>
													<div class="col-md-9">
														<input id="sitioWeb" name="sitioWeb" type="text" maxlength="40"
															placeholder="Ingrese sitio web de la Institucion (Campo requerido)"
															class="form-control" required="" value="${sitioWeb}">
													</div>
												</div>

												<!-- Email input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="email">Email</label>
													<div class="col-md-9">
														<input id="email" name="email" type="email" maxlength="40"
															placeholder="Ingrese email de la Institucion (Campo requerido)"
															class="form-control" required="" value="${email}">
													</div>
												</div>
												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Localidad</label>
													<div class="col-md-9">
														<form:select path="localidad" required="" multiple="false"
															class="form-control" id="selectLocalidades">
															<form:option value="${localidad}"
																label="Seleccione su Localidad" />
															<form:options items="${localidades}"
																itemValue="localidadesId" itemLabel="localidad" />
														</form:select>
													</div>
												</div>
												
												
												<td><label class="col-md-3 control-label" for="usuario">Elija
										la/s categoria/s</label> <form:checkboxes id="idCategoria"
 										path="idCategoria" items="${categoria}" 
 										itemValue="idCategoria" required="" itemLabel="nombre" /></td> 

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
										<form:form id="bajaInstitucion" method="post"
											action="submitDeleteInstitucion"
											modelAttribute="institucionBajaBean" class="form-signin">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label" for="institucion">Institucion</label>
													<div class="col-md-9">
														<form:select path="institucion" required=""
															multiple="false" class="form-control">
															<form:option value="" label="Seleccione una institucion" />
															<form:options items="${institucion}"
																itemValue="idInstitucion" itemLabel="nombre" />
														</form:select>
													</div>
												</div>

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
										<form:form id="updateInstitucion" method="post"
											action="submitUpdateInstitucion"
											modelAttribute="institucionBean" class="form-signin">
											<fieldset>


												<div class="form-group">
													<label class="col-md-3 control-label" for="institucion">Institucion
														a modificar</label>
													<div class="col-md-9">
														<form:select path="institucion" required=""
															multiple="false" class="form-control"
															onchange='cargarModificar("#updateInstitucion");'>
															<form:option value="" label="Seleccione su provincia" />
															<form:options items="${institucion}"
																itemValue="idInstitucion" itemLabel="nombre" />
														</form:select>
													</div>
												</div>

												<!-- Director input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="director">Director</label>
													<div class="col-md-9">
														<input id="directorModificar" name="director" type="text" maxlength="40"
															placeholder="Ingrese director de la Institucion (Campo requerido)"
															class="form-control" required="" value="${director}">
													</div>
												</div>

												<!-- Tipo input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="tipo">Tipo</label>
													<div class="col-md-9">
														<input id="tipoModificar" name="tipo" type="text" maxlength="40"
															placeholder="Ingrese tipo de Institucion (Campo requerido)"
															class="form-control" required="" value="${tipo}">
													</div>
												</div>

												<!-- Nombre input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="nombre">Nombre</label>
													<div class="col-md-9">
														<input id="nombreModificar" name="nombre" type="text" maxlength="40"
															placeholder="Ingrese nombre de la Institucion (Campo requerido)"
															class="form-control" required="" value="${nombre}">
													</div>
												</div>

												<!-- Direccion input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="direccion">Direccion</label>
													<div class="col-md-9">
														<input id="direccionModificar" name="direccion"
															type="text" maxlength="40"
															placeholder="Ingrese direccion de la Institucion (Campo requerido)"
															class="form-control" required="" value="${direccion}">
													</div>
												</div>

												<!-- Telefono input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="telefono">Telefono</label>
													<div class="col-md-9">
														<input id="telefonoModificar" name="telefono" type="text" maxlength="40"
															placeholder="Ingrese telefono de la Institucion (Campo requerido)"
															class="form-control" required="" value="${telefono}">
													</div>
												</div>

												<!-- Celular input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="celular">Celular</label>
													<div class="col-md-9">
														<input id="celularModificar" name="celular" type="text" maxlength="40"
															placeholder="Ingrese celular de la Institucion "
															class="form-control" value="${celular}">
													</div>
												</div>

												<!-- SitioWeb input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="sitioWeb">Sitio
														Web</label>
													<div class="col-md-9">
														<input id="sitioWebModificar" name="sitioWeb" type="text" maxlength="40"
															placeholder="Ingrese sitio web de la Institucion (Campo requerido)"
															class="form-control" required="" value="${sitioWeb}">
													</div>
												</div>

												<!-- Email input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="email">Email</label>
													<div class="col-md-9">
														<input id="emailModificar" name="email" type="email" maxlength="40"
															placeholder="Ingrese email de la Institucion (Campo requerido)"
															class="form-control" required="" value="${email}">
													</div>
												</div>

												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Localidad</label>
													<div class="col-md-9">
														<form:select path="localidad" required="" multiple="false"
															class="form-control" id="selectLocalidadesModificar">
															<form:option value="${localidad}"
																label="Seleccione su Localidad" />
															<form:options items="${localidades}"
																itemValue="localidadesId" itemLabel="localidad" />
														</form:select>
													</div>
												</div>


												<td><label class="col-md-3 control-label" for="usuario">Elija
										la/s categoria/s</label> <form:checkboxes id="idCategoria"
 										path="idCategoria" items="${categoria}" 
 										itemValue="idCategoria"  required="" itemLabel="nombre" /></td> 


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
