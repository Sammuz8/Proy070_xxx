
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core"%> 
<%@taglib uri="http://www.springframework.org/tags" 
			prefix="spring"%>
<!DOCTYPE html>
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; 
              charset=ISO-8859-1"> 
        <link rel="stylesheet"
              href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        
        <title>Producto</title> 
    </head> 
    <body> 
        <section> 
            <div class="jumbotron"> 
                <div class="container"> 
                    <h1>Producto</h1> 
                </div> 
            </div> 
        </section> 
        <section class="container"> 
            <div class="row"> 
                <div class="col-md-5"> 
                    <h3>${producto.nombre}</h3> 
                    <p>${producto.descripcion}</p> 
                    <p> 
                        <strong>Id Producto : </strong><span 
                            class="label label-warning">${producto.idProducto}
                        </span> 
                    </p> 
                    <p> 
                        <strong>Fabricante</strong> : ${producto.fabricante} 
                    </p> 
                    <p> 
                        <strong>Categoría</strong> : 
                        ${producto.categoria} 
                    </p> 
                    <p> 
                        <strong>Unidades disponible en stock </strong> :  ${producto.unidadesEnStock} 
                    </p> 
                    <h4>${producto.precioUnitario} €</h4> 
                    <p> 
                    
                     <spring:url value="/pedido/${producto.idProducto}/1" var="url" />
                     <a href="${ url }"
                        class="btn btn-warning btn-large"> 
	                       <span class="glyphicon-shopping-cart glyphicon">         
	                       </span> Realizar un Pedido 
	                   </a> 
                        
                    </p> 
                </div> 
            </div> 
        </section> 
    </body> 
</html> 
