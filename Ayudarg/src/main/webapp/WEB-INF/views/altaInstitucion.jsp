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
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">			
				<div class="row">
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading"><svg class="glyph stroked email"><use xlink:href="#stroked-email"></use></svg> Complete sus datos</div>
					<div class="panel-body">
						<form class="form-horizontal" action="" method="post">
							<fieldset>
							
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
										<button type="submit" class="btn btn-default btn-md pull-right">Donar</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>


</body>
</html>
