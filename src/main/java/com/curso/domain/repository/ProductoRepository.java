
package com.curso.domain.repository;

import com.curso.domain.Producto;
import java.util.List;

public interface ProductoRepository {
	List<Producto> getAllProductos();

	Producto getProductoPorId(String produId);

	List<Producto> getProductosPoCategoria(String categoria);

	Producto crearProducto(Producto producto);

	Producto modificarProducto(Producto producto);

	void borrarProducto(String idProducto);
}
