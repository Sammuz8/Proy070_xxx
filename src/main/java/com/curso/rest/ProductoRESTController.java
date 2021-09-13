package com.curso.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;
import com.curso.excepcion.GestionProductoException;
import com.curso.service.ProductoService;

@RestController
public class ProductoRESTController {

	@Autowired
	private ProductoService servicio;

	  @GetMapping("/rest/productos")
	  public List<Producto> all() {
	    return servicio.getTodosProductos();
	  }
	  

	  @PostMapping("/rest/productos")
	  public  Producto nuevoProducto(@RequestBody Producto nuevoProducto) {
	    return servicio.crearProducto(nuevoProducto);
	  }

	  // Single item
	  
	  @GetMapping("/rest/productos/{id}")
	  public  Producto getProducto(@PathVariable String id) {
	    
	    Producto producto = servicio.getProductoPorId(id);
	    if (producto == null) {
	    	throw new GestionProductoException(id, "Producto no encontrado");
	    }
	    return producto;
	  }

	  //modificar
	  @PutMapping("/rest/productos/{id}")
	  public  Producto  modificarProdu(@RequestBody Producto productoModificado, 
			                           @PathVariable String id) {
	    
	      Producto modif = servicio.modificar(productoModificado);
		  return modif;
	  }

	  @DeleteMapping("/rest/productos/{id}")
	  public void deleteEmployee(@PathVariable String id) {
	       servicio.borrar(id);
	  }


}
