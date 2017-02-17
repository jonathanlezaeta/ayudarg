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
<title>Registrar Institucion</title>
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


	</div><!--/.sidebar-->
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
				<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading"><svg class="glyph stroked email"><use xlink:href="#stroked-email"></use></svg> Registrar Institucion</div>
					<div class="panel-body">
					
						<form:form id="institucionForm" method="post" action="submitAltaInstitucion" modelAttribute="institucionBean" class="form-signin">
							<fieldset>
							
<div id="exTab1" class="container">	
<ul  class="nav nav-pills">
			<li class="active">
        <a  href="#1a" data-toggle="tab">Overview</a>
			</li>
			<li><a href="#2a" data-toggle="tab">Using nav-pills</a>
			</li>
			<li><a href="#3a" data-toggle="tab">Applying clearfix</a>
			</li>
  		<li><a href="#4a" data-toggle="tab">Background color</a>
			</li>
		</ul>

			<div class="tab-content clearfix">
			  <div class="tab-pane active" id="1a">
          <h3>Content's background color is the same for the tab</h3>
				</div>
				<div class="tab-pane" id="2a">
          <h3>We use the class nav-pills instead of nav-tabs which automatically creates a background color for the tab</h3>
				</div>
        <div class="tab-pane" id="3a">
          <h3>We applied clearfix to the tab-content to rid of the gap between the tab and the content</h3>
				</div>
          <div class="tab-pane" id="4a">
          <h3>We use css to change the background color of the content to be equal to the tab</h3>
				</div>
			</div>
  </div>
					
								<!-- Director input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="director">Director</label>
									<div class="col-md-9">
									<input id="director" name="director" type="text" placeholder="Ingrese director de la Institucion" class="form-control">
									</div>
								</div>
							
								<!-- Ciudad input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="ciudad">Ciudad</label>
									<div class="col-md-9">
										<input id="ciudad" name="ciudad" type="text" placeholder="Ingrese ciudad de la Institucion" class="form-control">
									</div>
								</div>
								
								<!-- Tipo input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="tipo">Tipo</label>
									<div class="col-md-9">
										<input id="tipo" name="tipo" type="text" placeholder="Ingrese tipo de Institucion" class="form-control">
									</div>
								</div>
								
								<!-- Nombre input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="nombre">Nombre</label>
									<div class="col-md-9">
										<input id="nombre" name="nombre" type="text" placeholder="Ingrese nombre de la Institucion" class="form-control">
									</div>
								</div>
								
								<!-- Direccion input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="direccion">Direccion</label>
									<div class="col-md-9">
										<input id="direccion" name="direccion" type="text" placeholder="Ingrese direccion de la Institucion" class="form-control">
									</div>
								</div>
								
								<!-- Telefono input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="telefono">Telefono</label>
									<div class="col-md-9">
										<input id="telefono" name="telefono" type="text" placeholder="Ingrese telefono de la Institucion" class="form-control">
									</div>
								</div>
								
								<!-- Celular input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="celular">Celular</label>
									<div class="col-md-9">
										<input id="celular" name="celular" type="text" placeholder="Ingrese celular de la Institucion" class="form-control">
									</div>
								</div>
								
								<!-- SitioWeb input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="sitioWeb">Sitio Web</label>
									<div class="col-md-9">
										<input id="sitioWeb" name="sitioWeb" type="text" placeholder="Ingrese sitio web de la Institucion" class="form-control">
									</div>
								</div>
								
								<!-- Email input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="email">Email</label>
									<div class="col-md-9">
										<input id="email" name="email" type="text" placeholder="Ingrese email de la Institucion" class="form-control">
									</div>
								</div>
								
								
								<!-- Form actions -->
								<div class="form-group">
									<div class="col-md-12 widget-right">
										<button type="submit" class="btn btn-default btn-md pull-right">Registrar</button>
									</div>
								</div>
							</fieldset>
						 </form:form>
					</div>
				</div>


</body>
</html>