package com.curso.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;
import com.curso.excepcion.GestionProductoException;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductoServiceImp implements ProductoService {

	@Autowired
	// @Qualifier("InMemoryProductosRepository")
	@Qualifier("JPAProductosRepository")
	private ProductoRepository productoRepositorio;

	@Override
	public List<Producto> getTodosProductos() {
		// TODO Auto-generated method stub
		return productoRepositorio.getAllProductos();
	}

	@Override
	public List<Producto> getProductosPorCategoria(String categoria) {
		return productoRepositorio.getProductosPoCategoria(categoria);
	}

	@Override
	public Producto getProductoPorId(String productId) {
		// TODO Auto-generated method stub

		return productoRepositorio.getProductoPorId(productId);
	}

	@Override
	public Producto crearProducto(Producto nuevoProducto) {
		// TODO Auto-generated method stub
		//tx begin
		Producto p = productoRepositorio.getProductoPorId(nuevoProducto.getIdProducto());
		if (p != null) {
			throw new GestionProductoException(nuevoProducto.getIdProducto(),
					"No pudo crear . ya existe el producto con id ");
		}

		return productoRepositorio.crearProducto(nuevoProducto);
		//si no hay excepciones runtime exception hace commit
		//si hay excepcion hace rollback, todos los cambios hechos en este metodo pierde
	}
	
	@Override
	public Producto modificar(Producto producto) {
		return productoRepositorio.modificarProducto(producto);
	}


	@Override
	public void borrar(String id) {
		//borrar producto . e interario
		productoRepositorio.borrarProducto(id);
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED,
	              noRollbackFor = GestionProductoException.class )
	public void cambiarPrecio(List<Producto> productos, double nuevoPrecio) {
		
		// cambio el precio de los productos que me llegan
		// pero solo si el nuevo precio es mayor que el actual
		
		
		// tx.begintransa
		for(Producto p: productos) {
			Producto pBD = getProductoPorId(p.getIdProducto());
			if (pBD == null) {
				throw new GestionProductoException("No se puede n modo....");
			}else if(pBD.getPrecioUnitario().equals(new BigDecimal(nuevoPrecio))){
			   	throw new GestionProductoException("No se puede n modo....");
			}else {
				pBD.setPrecioUnitario(new BigDecimal(nuevoPrecio));
				productoRepositorio.modificarProducto(pBD);
			}
		}
		/*
		 *  Aunque haya hecho algun cambio de precio
		 *  si alguno de los productos lanza una exepcion 
		 *  GestionProductoException que es RuntimeException
		 *  hace rollback de todo
		 */
		
	}

}
