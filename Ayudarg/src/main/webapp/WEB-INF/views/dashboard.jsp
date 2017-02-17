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
			<li><a href="/app/bajaUsuario"><svg class="glyph stroked line-graph"><use xlink:href="/bajaUsuario"></use></svg> Usuarios</a></li>
		</ul>

		

	</div><!--/.sidebar-->
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Categorias</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="icon-grid">
							<div class="col-lg-3 col-md-4 col-sm-6">
								<svg class="glyph stroked app window with content"><use xlink:href="#stroked-app-window-with-content"/></svg>
								<pre>&lt;svg class="glyph stroked app window with content">&lt;use xlink:href="#stroked-app-window-with-content"/>&lt;/svg></pre>
							</div>
							<div class="col-lg-3 col-md-4 col-sm-6">
								<svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg>
								<pre>&lt;svg class="glyph stroked app-window">&lt;use xlink:href="#stroked-app-window">&lt;/use>&lt;/svg></pre>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->		
		
		
	</div><!--/.main-->
		
	</div><!--/.main-->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Demandas</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="icon-grid">
							<div class="col-lg-3 col-md-4 col-sm-6">
								<svg class="glyph stroked app window with content"><use xlink:href="#stroked-app-window-with-content"/></svg>
								<pre>&lt;svg class="glyph stroked app window with content">&lt;use xlink:href="#stroked-app-window-with-content"/>&lt;/svg></pre>
							</div>
							<div class="col-lg-3 col-md-4 col-sm-6">
								<svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg>
								<pre>&lt;svg class="glyph stroked app-window">&lt;use xlink:href="#stroked-app-window">&lt;/use>&lt;/svg></pre>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->		
		
		
	</div><!--/.main-->
	
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Donaciones</h1>
			</div>
		</div><!--/.row-->
				
		
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="icon-grid">
							<div class="col-lg-3 col-md-4 col-sm-6">
								<svg class="glyph stroked app window with content"><use xlink:href="#stroked-app-window-with-content"/></svg>
								<pre>&lt;svg class="glyph stroked app window with content">&lt;use xlink:href="#stroked-app-window-with-content"/>&lt;/svg></pre>
							</div>
							<div class="col-lg-3 col-md-4 col-sm-6">
								<svg class="glyph stroked app-window"><use xlink:href="#stroked-app-window"></use></svg>
								<pre>&lt;svg class="glyph stroked app-window">&lt;use xlink:href="#stroked-app-window">&lt;/use>&lt;/svg></pre>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div><!--/.row-->		
		
		
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

</html>