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
<title>Recursos</title>
<style>
body {
	background: transparent url("resources/img/background.jpg") no-repeat;
	background-size: cover;
	padding-top: 35px;
}
</style>
<script language="javascript">
	function cargarModificar(value) {
		if (document.getElementById("recursoModificar").value != "") {
			$
					.ajax({
						type : "POST",
						data : $(value).serialize(),
						dataType : 'json',
						url : '/app/getRecursoById',
						success : function(data) {
							var res = data;
							document.getElementById("nombreModificar").value = res.nombre;
							document.getElementById("descripcionModificar").value = res.descripcion;
							document.getElementById("cantidadModificar").value = res.cantidad;
							checkboxes = document.getElementsByTagName('input'); //obtenemos todos los controles del tipo Input
							for (i = 0; i < checkboxes.length; i++) //recoremos todos los controles
							{
								if (checkboxes[i].type == "checkbox") //solo si es un checkbox entramos
								{
									for (j = 0; j < res.idCategoria.length; j++) {
										if (checkboxes[i].value == res.idCategoria[j])
											checkboxes[i].checked = true; //si es un checkbox le damos el valor del checkbox que lo llam� (Marcar/Desmarcar Todos)
									}
								}
							}
						},
						error : function(e) {
							alert("Error en el servidor, por favor, intentalo de nuevo mas tarde");
						}
					});
		} else {
			document.getElementById("nombreModificar").value = "";
			document.getElementById("descripcionModificar").value = "";
			document.getElementById("cantidadModificar").value = "";
			checkboxes = document.getElementsByTagName('input'); //obtenemos todos los controles del tipo Input
			for (i = 0; i < checkboxes.length; i++) //recoremos todos los controles
			{
				if (checkboxes[i].type == "checkbox") //solo si es un checkbox entramos
				{
					checkboxes[i].checked = false; //si es un checkbox le damos el valor del checkbox que lo llam� (Marcar/Desmarcar Todos)
				}
			}
		}
	}
</script>
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
						Recursos
					</div>
					<div class="panel-body">
						<h4 style="color: red;">${menssage}</h4>
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
										<form:form id="recursoForm" method="post"
											action="submitAltaRercurso" modelAttribute="recursoBean"
											class="form-signin">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Institucion</label>
													<div class="col-md-9">
														<form:select path="idInstitucion" required=""
															multiple="false" class="form-control">
															<form:option value="" label="Seleccione..." />
															<form:options items="${instituciones}"
																itemValue="idInstitucion" required="" itemLabel="nombre" />
														</form:select>
													</div>
												</div>
												<td><label class="col-md-3 control-label" for="usuario">Elija
														la/s categoria/s</label> <form:checkboxes id="idCategoria"
														path="idCategoria" items="${categoria}"
														itemValue="idCategoria" itemLabel="nombre" /></td> </br> </br>

												<!-- Nombre input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="nombre">Nombre</label>
													<div class="col-md-9">
														<input id="nombre" name="nombre" type="text" maxlength="40"
															placeholder="Ingrese nombre del recurso"
															class="form-control" required="" value="">
													</div>
												</div>

												<!-- Cantidad input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="cantidad">Cantidad</label>
													<div class="col-md-9">
														<input id="cantidad" name="cantidad" type="number" maxlength="40"
															placeholder="Ingrese cantidad a donar"
															class="form-control" required="" value="${cantidad}">
													</div>
												</div>
												<!-- Cantidad input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="cantidad">Descripci�n</label>
													<div class="col-md-9">
														<textarea id="descripcion" name="descripcion"
															placeholder="Ingrese una breve descripcion"
															class="form-control" required="" value=""></textarea>
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
										<form:form id="bajaRecurso" method="post"
											action="submitDeleteRercurso" modelAttribute="recursoBean"
											class="form-signin">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label" for="nombre">Recurso</label>
													<div class="col-md-9">
														<form:select path="id" required="" multiple="false"
															class="form-control">
															<form:option value="" label="Seleccione un recurso" />
															<form:options items="${recursos}" itemValue="id"
																required="" itemLabel="nombre" />
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
										<form:form id="recursoModificacion" method="post"
											action="submitUpdateRercurso" modelAttribute="recursoBean"
											class="form-signin">
											<fieldset>
												<div class="form-group">
													<label class="col-md-3 control-label" for="usuario">Recurso
														a modificar</label>
													<div class="col-md-9">
														<form:select path="id" required="" multiple="false"
															class="form-control" id="recursoModificar"
															onchange='cargarModificar("#recursoModificacion");'>
															<form:option value="" label="Seleccione un recurso" />
															<form:options items="${recursos}" itemValue="id"
																required="" itemLabel="nombre" />
														</form:select>
													</div>
												</div>

												<td><label class="col-md-3 control-label" for="usuario">Elija
														la/s categoria/s</label> <form:checkboxes id="idCategoria"
														path="idCategoria" items="${categoria}"
														itemValue="idCategoria" itemLabel="nombre" /></td> </br> </br>

												<!-- Nombre input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="nombre">Nombre</label>
													<div class="col-md-9">
														<input id="nombreModificar" name="nombre" type="text" maxlength="40"
															placeholder="Ingrese nombre del recurso"
															class="form-control" required="" value="">
													</div>
												</div>

												<!-- Cantidad input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="cantidad">Cantidad</label>
													<div class="col-md-9">
														<input id="cantidadModificar" name="cantidad" type="number" maxlength="40"
															placeholder="Ingrese cantidad a donar"
															class="form-control" required="" value="">
													</div>
												</div>
												<!-- Cantidad input-->
												<div class="form-group">
													<label class="col-md-3 control-label" for="cantidad">Descripci�n</label>
													<div class="col-md-9">
														<textarea id="descripcionModificar" name="descripcion"
															placeholder="Ingrese una breve descripcion"
															class="form-control" required="" value=""></textarea>
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
