package com.curso.service;

import java.util.List;

import com.curso.domain.Producto;

public interface ProductoService {

	List<Producto> getTodosProductos();

	Producto getProductoPorId(String productId);

	Producto crearProducto(Producto nuevoProducto);

	List<Producto> getProductosPorCategoria(String categoria);
	
	Producto modificar(Producto producto);

	void borrar(String id);

	void cambiarPrecio(List<Producto> productos, double nuevoPrecio);
}
