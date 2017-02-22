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
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">0
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demandas</title>
<script language="javascript">
	function showmydiv() {
		document.getElementById('demandar').style.display = "block";
	}
	function cargarLocalidades(value){
		$.ajax({
			type: "POST",
			data: $("#demandarForm").serialize(),
			dataType: 'json',
			url: '/demandar/getLocalidadesById', 
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
		<!-- /.container-fluid -->
	</nav>

	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<%-- 		<form role="search"> --%>
		<!-- 			<div class="form-group"> -->
		<!-- 			<input type="text" class="form-control" placeholder="Search"> -->
		<!--  			</div> -->
		<%-- 		</form> --%>
		<ul class="nav menu">
			<li><a href="/app/dashboard"><svg
						class="glyph stroked dashboard-dial">
						<use xlink:href="/dashboard"></use></svg> Inicio</a></li>
			<li><a href="/app/donar"><svg class="glyph stroked calendar">
						<use xlink:href="/donar"></use></svg> Donar</a></li>
			<li><a href="/app/demandar"><svg
						class="glyph stroked line-graph">
						<use xlink:href="/demandar"></use></svg> Demandar</a></li>
			<li><a href="/app/altaInstitucion"><svg
						class="glyph stroked line-graph">
						<use xlink:href="/altaInstitucion"></use></svg> Instituciones</a></li>
			<li><a href="/app/altaCategoria"><svg
						class="glyph stroked line-graph">
						<use xlink:href="/altaCategoria"></use></svg> Categorias</a></li>
			<li><a href="/app/bajaUsuario"><svg
						class="glyph stroked line-graph">
						<use xlink:href="/bajaUsuario"></use></svg> Usuarios</a></li>
		</ul>

	</div>
	<!--/.sidebar-->
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<svg class="glyph stroked email">
							<use xlink:href="#stroked-email"></use></svg>
						Complete sus datos
					</div>
					<div class="panel-body">

						<form:form id="demandarForm" method="post"
							action="submitAltaDemanda" modelAttribute="demandarBean"
							class="form-signin">
							<fieldset>


							
								<td>
								<label class="col-md-3 control-label" for="usuario">Elija la/s categorias</label>
								<form:checkboxes path="idCategoria" items="${categoria}" itemValue="idCategoria" itemLabel="nombre" />
								</td>
		


								<div class="form-group">
							<form:select path="provincia" required="" multiple="false"
								class="form-control" id='selectProvincias'
								onchange='cargarLocalidades(this.value);'>
								<form:option value="NONE" label="Seleccione su provincia"/>
								<form:options items="${provincias}" itemValue="idProvincia"
									itemLabel="provincia" />
							</form:select>
						</div>
						
						<div class="form-group">
							<form:select path="localidad" required="" multiple="false"
								class="form-control" id="selectLocalidades">
								<form:options items="${localidades}" itemValue="localidadesId"
									itemLabel="localidad" />
							</form:select>
						</div>

								<div class="form-group">
									<div class="col-md-12 widget-right">
										<button type="submit"
											class="btn btn-default btn-md pull-right">Solicitar</button>
									</div>
								</div>

							</fieldset>
						</form:form>
					</div>
				</div>
</body>
</html>
