<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<link href="<c:url value="/resources/css/css/datepicker3.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/styles.css" />"
	rel="stylesheet">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenidos a Ayudarg</title>
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
		<c:choose>
			<c:when test="${rol.equals('A')}">
				<ul class="nav menu">
					<li><a href="/app/dashboard"><svg
								class="glyph stroked dashboard-dial">
						<use xlink:href="/dashboard"></use></svg> Inicio</a></li>
					<li><a href="/app/donar"><svg
								class="glyph stroked calendar">
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
			</c:when>
			<c:when test="${rol.equals('U')}">
				<ul class="nav menu">
					<li><a href="/app/dashboard"><svg
								class="glyph stroked dashboard-dial">
						<use xlink:href="/dashboard"></use></svg> Inicio</a></li>
					<li><a href="/app/donar"><svg
								class="glyph stroked calendar">
						<use xlink:href="/donar"></use></svg> Donar</a></li>
					<li><a href="/app/demandar"><svg
								class="glyph stroked line-graph">
						<use xlink:href="/demandar"></use></svg>Solicitar un recurso</a></li>
				</ul>
			</c:when>
			<c:when test="${rol.equals('I')}">
				<ul class="nav menu">
					<li><a href="/app/dashboard"><svg
								class="glyph stroked dashboard-dial">
						<use xlink:href="/dashboard"></use></svg> Inicio</a></li>
					<li><a href="/app/donar"><svg
								class="glyph stroked calendar">
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
			</c:when>
		</c:choose>
	</div>
	<!--/.sidebar-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		</br>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header" style="color:#fff;">Instituciones disponibles para donar:</h1>
			</div>
		</div>
		<!--/.row-->


		<div class="row">
			<c:forEach items="${instituciones}" var="element">
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-body">

							<div class="icon-grid">
								<div class="col-md-12">
									<h2>
										<p>${element.nombre}</p>
									</h2>
									<p>Dirección: ${element.direccion}</p>
									<p>Email: ${element.email}</p>
									<p>Teléfono: ${element.telefono}</p>
									<p>Web: ${element.sitioWeb}</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<!--/.row-->


	</div>
	<!--/.main-->

	</div>
	<!--/.main-->


</body>

</html>