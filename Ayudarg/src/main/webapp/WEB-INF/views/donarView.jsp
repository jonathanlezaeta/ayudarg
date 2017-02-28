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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donaciones</title>
<script language="javascript">
	function cargarLocalidades(value){
		$.ajax({
			type: "POST",
			data: $("#donarForm").serialize(),
			dataType: 'json',
			url: '/app/getLocalibadesByIdDonar', 
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
						Complete sus datos
					</div>
					<div class="panel-body">
							<h4 style="color: red;">${errorRegistrar}</h4>
						<form:form id="donarForm" method="post"
							action="submitAltaDonacion" modelAttribute="donarBean"
							class="form-signin">
							<fieldset>

								<td><label class="col-md-3 control-label" for="usuario">Elija
										la/s categoria/s</label> <form:checkboxes id="idCategoria"
										path="idCategoria" items="${categoria}"
										itemValue="idCategoria" itemLabel="nombre" /></td> </br> </br>

								<div class="form-group">
									<label class="col-md-3 control-label" for="usuario">Provincia</label>
									<div class="col-md-9">
										<form:select path="provincia" required="" multiple="false"
											class="form-control" id='selectProvincias'
											onchange='cargarLocalidades(this.value);'>
											<form:option value="${provincias}"
												label="Seleccione su Provincia" />
											<form:options items="${provincias}" itemValue="idProvincia"
												itemLabel="provincia" />
										</form:select>
									</div>
								</div>


								<div class="form-group">
									<label class="col-md-3 control-label" for="usuario">Localidad</label>
									<div class="col-md-9">
										<form:select path="localidad" required="" multiple="false"
											class="form-control" id="selectLocalidades">
											<form:option value="${localidades}"
												label="Seleccione su Ciudad" />
											<form:options items="${localidades}"
												itemValue="localidadesId" itemLabel="localidad" />
										</form:select>
									</div>
								</div>

								<div class="form-group">
									<div class="col-md-12 widget-right">
										<button type="submit"
											class="btn btn-default btn-md pull-right">Donar</button>
									</div>
								</div>

							</fieldset>
						</form:form>
					</div>
				</div>
</body>
</html>
