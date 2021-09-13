
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Productos</h1>
				<p>Todos los productos disponibles en tienda</p>
			</div>
		</div>

	</section>
	<section class="container">
		<div class="row">
			<c:forEach items="${productos}" var="producto">
				<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
					<div class="thumbnail">
						<div class="caption">
							<h3>${producto.nombre}</h3>
							<p>${producto.descripcion}</p>
							<p>${producto.precioUnitario}€</p>
							<p>Hay ${producto.unidadesEnStock} unidades in stock</p>
							<p>
								<s:url value="/pedido/${producto.idProducto}/1" var="url" />
								<a href="${ url }" 
									class="btn btn-warning btn-large"> Pedir 1 unidad </a> 
								<a href="producto?id=${producto.idProducto}"
									class="btn btn-warning btn-large"> Ver Producto </a>
									
								<a href="producto/id/${producto.idProducto}"
									class="btn btn-warning btn-large"> Path Ver Producto </a>	
									 
								<a href="producto/edit?id=${producto.idProducto}"
									class="btn btn-warning btn-large"> Modificar Producto </a> 
								<a href="producto/delete?id=${producto.idProducto}"
									class="btn btn-warning btn-large"> Borrar Producto </a>
							</p>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	<section>
		<div class="container">
			<a href="productos/nuevo" class="btn btn-warning btn-large"> Nuevo</a>
		</div>
	</section>
</body>
</html>
