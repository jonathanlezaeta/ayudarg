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
<title>Registrar Categoria</title>
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
						<use xlink:href="/altaInstitucion"></use></svg> Institucion</a></li>
			<li><a href="/app/altaCategoria"><svg
						class="glyph stroked line-graph">
						<use xlink:href="/altaCategoria"></use></svg> Categorias</a></li>
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
						Registrar Categoria
					</div>
					<div class="panel-body">
	        <form:form id="altaCategoriaForm" method="post" action="submitRegistrar" modelAttribute="categoriaBean" class="form-signin">
							<fieldset>

								<!-- Nombre put-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="director">Nombre</label>
									<div class="col-md-9">
										<input id="nombre" name="nombre" type="text"
											placeholder="Ingrese nombre de la categoria"
											class="form-control">
									</div>
								</div>

								<!-- SubCategoria input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="ciudad">Subcategoria</label>
									<div class="col-md-9">
										<form:select path="categoria" multiple="false">
											<form:option value="-" label="--Elija una" />
											<form:options items="${categoria}" itemValue="idCategoria"
												itemLabel="nombre" />
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
				</div>
</body>
</html>
