
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Modificar Producto</title>
</head>
<body>
<body>
	<section>
		<div class="pull-right" style="padding-right: 50px">
			<a href="?language=en">English</a>| <a href="?language=es">Spanish</a>
		</div>
	</section>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Productos</h1>
				<p>Modificar Producto</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form method="POST" modelAttribute="productoModif"
			class="form-horizontal">
			<fieldset>
				<legend>
					<spring:message code="producto.alta.titulo" />
				</legend>

				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="idProducto">
						<spring:message code="producto.idProducto" />

					</label>
					<div class="col-lg-10">
						<form:input id="idProducto" path="idProducto" type="text"
							class="form:input-large" />
						<form:errors path="idProducto" cssClass="text-danger" />
					</div>

				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="nombre">Nombre</label>
					<div class="col-lg-10">
						<form:input id="nombre" path="nombre" type="text"
							class="form:input-large" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="descripcion">Descripción</label>
					<div class="col-lg-10">
						<form:textarea id="descripcion" path="descripcion" rows="2" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="preciUnit">Precio
						Unitario</label>
					<div class="col-lg-10">
						<form:input id="preciUnit" path="precioUnitario" type="text"
							class="form:input-large" />
					</div>
				</div>

			
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="fabricante">Fabricante
					</label>
					<div class="col-lg-10">
						<form:input id="fabricante" path="fabricante" type="text"
							class="form:input-large" />
					</div>
				</div>
		
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="categoria">Categoría</label>
					<div class="col-lg-10">
						<form:input id="categoria" path="categoria" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"
						for="unidadesEnStock">Unidades en Stock</label>
					<div class="col-lg-10">
						<form:input id="unidadesEnStock" path="unidadesEnStock"
							type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2"
						for="unidadesEnPedido">Unidades en Pedido</label>
					<div class="col-lg-10">
						<form:input id="unidadesEnPedido" path="unidadesEnPedido"
							type="text" class="form:input-large" />
					</div>
				</div>


				<div class="form-group">
					<label class="control-label col-lg-2" for="disponible">Disponible</label>
					<div class="col-lg-10">
						<form:checkbox id="disponible" path="disponible" />
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-lg-2" for="condiciones">Estado</label>
					<div class="col-lg-10">
						<form:radiobutton path="condiciones" value="Nuevo" />
						Nuevo
						<form:radiobutton path="condiciones" value="Viejo" />
						Viejo
						<form:radiobutton path="condiciones" value="Renovado" />
						Renovado
					</div>
				</div>

				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnModif"
							class="btn 
                                   btn-primary"
							value="Guardar Cambios" />
					</div>
				</div>
			</fieldset>

		</form:form>
	</section>
</body>
</html>

