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
	<div class="row">
  		<div class="col-md-6 col-md-offset-3">
	        <form:form id="registrarseForm" method="post" action="submitAltaInstitucion" modelAttribute="institucionBean" class="form-signin">
				<h2 class="form-signin-heading" style="text-align: center;">Ayudarg</h2>
				<label for="inputEmail" class="sr-only">Director</label> 
				<input type="text" id="director" class="form-control" placeholder="Ingrese Director de la Institucion" required="" autofocus="" name="director"> 
				<br>
				<label for="inputEmail" class="sr-only">Ciudad</label> 
				<input type="text" id="ciudad" class="form-control" placeholder="Ingrese Ciudad de la Institucion" required="" autofocus="" name="ciudad"> 
				<br>
				<label for="inputEmail" class="sr-only">Tipo</label> 
				<input type="text" id="tipo" class="form-control" placeholder="Ingrese Tipo de la Institucion" required="" autofocus="" name="tipo"> 
				<br>
				<label for="inputEmail" class="sr-only">Nombre</label> 
				<input type="text" id="nombre" class="form-control" placeholder="Ingrese Nombre de la Institucion" required="" autofocus="" name="nombre"> 
				<br>
				<label for="inputEmail" class="sr-only">Direccion</label> 
				<input type="text" id="direccion" class="form-control" placeholder="Ingrese Dirección de la Institucion" required="" autofocus="" name="direccion"> 
				<br>
				<label for="inputEmail" class="sr-only">Telefono</label> 
				<input type="text" id="telefono" class="form-control" placeholder="Ingrese Telefono de la Institucion" required="" autofocus="" name="telefono"> 
				<br>
				<label for="inputEmail" class="sr-only">Celular</label> 
				<input type="text" id="celular" class="form-control" placeholder="Ingrese Celular de la Institucion" required="" autofocus="" name="celular"> 
				<br>
				<label for="inputEmail" class="sr-only">Sitio Web</label> 
				<input type="text" id="sitioWeb" class="form-control" placeholder="Ingrese Sitio Web de la Institucion" required="" autofocus="" name="sitio web"> 
				<br>
				<label for="inputEmail" class="sr-only">Email</label> 
				<input type="text" id="email" class="form-control" placeholder="Ingrese Email de la Institucion" required="" autofocus="" name="email"> 
				<br>
				<button class="btn btn-lg btn-primary btn-block" style="width:50%; margin-left:auto; margin-right:auto;" type="submit">Aceptar</button>
	        </form:form>
        </div>
	</div>
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
