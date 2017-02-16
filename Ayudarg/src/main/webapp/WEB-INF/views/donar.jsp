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
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Donaciones</title>
</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
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
							
		</div><!-- /.container-fluid -->
	</nav>
		
	<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
<%-- 		<form role="search"> --%>
<!-- 			<div class="form-group"> --> 
<!-- 			<input type="text" class="form-control" placeholder="Search"> --> 
<!--  			</div> --> 
<%-- 		</form> --%>
			<ul class="nav menu">
			<li><a href="/app/dashboard"><svg class="glyph stroked dashboard-dial"><use xlink:href="/dashboard"></use></svg> Inicio</a></li>
			<li><a href="/app/donar"><svg class="glyph stroked calendar"><use xlink:href="/donar"></use></svg> Donar</a></li>
			<li><a href="/app/demandar"><svg class="glyph stroked line-graph"><use xlink:href="/demandar"></use></svg> Demandar</a></li>
			<li><a href="/app/altaInstitucion"><svg class="glyph stroked line-graph"><use xlink:href="/altaInstitucion"></use></svg> Institucion</a></li>
			<li><a href="/app/altaCategoria"><svg class="glyph stroked line-graph"><use xlink:href="/altaCategoria"></use></svg> Categorias</a></li>
		</ul>

		
	</div><!--/.main-->		

	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script>
		!function ($) {
			$(document).on("click","ul.nav li.parent > a > span.icon", function(){		  
				$(this).find('em:first').toggleClass("glyphicon-minus");	  
			}); 
			$(".sidebar span.icon").find('em:first').addClass("glyphicon-plus");
		}(window.jQuery);

		$(window).on('resize', function () {
		  if ($(window).width() > 768) $('#sidebar-collapse').collapse('show')
		})
		$(window).on('resize', function () {
		  if ($(window).width() <= 767) $('#sidebar-collapse').collapse('hide')
		})
	</script>	
</body>
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
				<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading"><svg class="glyph stroked email"><use xlink:href="#stroked-email"></use></svg> Complete sus datos</div>
					<div class="panel-body">
					
						<form:form id="donarForm" method="post" action="submitAltaDonacion" modelAttribute="recursoBean" class="form-signin">
							<fieldset>
							
<!-- 								Categoria input -->
<!-- 								<div class="form-group"> -->
<!-- 									<label class="col-md-3 control-label" for="ciudad">Categoria</label> -->
<!-- 									<div class="col-md-9"> -->
<%-- 										<form:select path="categoria" multiple="false"> --%>
<%-- 											<form:options items="${categoria}" itemValue="categoriaIdCategoria" --%>
<%-- 												itemLabel="nombre" /> --%>
<%-- 										</form:select> --%>
<!-- 									</div> -->
<!-- 								</div> -->
							
								<!-- Recurso input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="nombre">Recurso</label>
									<div class="col-md-9">
										<input id="nombre" name="nombre" type="text" placeholder="Nombre del recurso" class="form-control">
									</div>
								</div>
								
								<!-- Fecha input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="fechaCreacion">Fecha donacion</label>
									<div class="col-md-9">
										<input id="fechaCreacion" name="fechaCreacion" type="date" placeholder="Fecha de hoy" class="form-control">
									</div>
								</div>
				
								Institución input
								<div class="form-group">
									<label class="col-md-3 control-label" for="institucion">Institucion</label>
									<div class="col-md-9">
										<form:select path="institucion" multiple="false">
											<form:options items="${recurso}" itemValue="institucionIdInstitucion"
 												itemLabel="nombre" />
 										</form:select> 
									</div>
								</div>
								
								<!-- Cantidad input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="cantidad">Cantidad</label>
									<div class="col-md-9">
										<input id="cantidad" name="cantidad" type="text" placeholder="Cantidad que donará" class="form-control">
									</div>
								</div>
								
								
<!-- 								Descripción body -->
<!-- 								<div class="form-group"> -->
<!-- 									<label class="col-md-3 control-label" for="message">Descripción</label> -->
<!-- 									<div class="col-md-9"> -->
<!-- 										<textarea class="form-control" id="message" name="message" placeholder="Comentarios..." rows="5"></textarea> -->
<!-- 									</div> -->
<!-- 								</div> -->
								
								<!-- Form actions -->
								<div class="form-group">
									<div class="col-md-12 widget-right">
										<button type="submit" class="btn btn-default btn-md pull-right">Donar</button>
									</div>
								</div>
							</fieldset>
						</form:form>
					</div>
				</div>

			</body>
</html>