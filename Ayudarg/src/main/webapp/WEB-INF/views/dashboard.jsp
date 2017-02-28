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
<title>Bienvenidos a Ayudarg</title>
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
		<!-- /.container-fluid -->
	</nav>

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
						<svg class="glyph stroked email">
							<use xlink:href="#stroked-email"></use></svg>
						Somos Ayudarg
					</div>
					<div class="panel-body">

						<label class="col-md-12 control-label" for="usuario">Muchos organismos internacionales consideran a las ONGs como instrumentos fundamentales para atacar la pobreza y fortalecer el desarrollo sostenido.

Sin embargo, aunque se habla permanentemente de este tipo de entidades, muchos no saben con exactitud la labor que cumplen esos organismos.

En este sentido, varias publicaciones consignan la clase de actividades que desarrollan las ONGs y definen su carácter.


Aunque diversas entidades han hecho aproximaciones, la definición del Banco Mundial parece ser la que contiene la tipología implícita de lo que son ellas.

En concepto de dicho banco las Organizaciones No Gubernamentales (ONGs), son entidades privadas que se dedican a aliviar sufrimientos, promover los intereses de los pobres, proteger el medio ambiente, proveer servicios sociales fundamentales o fomentar el desarrollo comunitario.


Comprenden muchos grupos e instituciones total o parcialmente independientes del gobierno, cuyos objetivos son principalmente de índole humanitaria, más que comercial.

Son entidades privadas en países industriales que apoyan el desarrollo internacional; grupos locales organizados en los planos regional o nacional y grupos comunitarios dirigidos por sus propios miembros.


Las ONGs incluyen asociaciones religiosas y de beneficencia, que movilizan fondos privados para el desarrollo, proporcionan alimentos y servicios de planificación familiar y fomentan la organización comunitaria.

También abarcan cooperativas independientes, asociaciones comunitarias, sociedades de usuarios de servicios públicos, grupos de mujeres y asociaciones pastorales.


Así mismo, son Organizaciones No Gubernamentales los grupos cívicos que procuran que se tome conciencia de los problemas sociales y ambientales e influir en las políticas pertinentes .

Según una publicación de Fundación Social, aunque esta definición es conceptualmente insuficiente ofrece una caracterización de diversas formas de ONGs, que aporta elementos para la elaboración de una tipología del fenómeno y para sectorizar su universo .</label>
						
					</div>
				</div>
</body>
</html>
