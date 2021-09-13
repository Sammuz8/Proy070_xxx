package com.curso.domain.repository;

import com.curso.domain.Producto;
import java.util.logging.Logger;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("InMemoryProductosRepository")
public class EnMemoriaProductoRepository  implements ProductoRepository{

    private List<Producto> listaDeProductos = new ArrayList<Producto>();
    private Logger log = Logger.getLogger("EnMemoriaProductoRepository.class");
    
    //contructor
    
    public EnMemoriaProductoRepository() {
    log.info("........... instanciando EnMemoriaProductoRepository");
    Producto iphone = new Producto("P1234","iPhone 5s", new BigDecimal(500));
    iphone.setDescripcion("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
    iphone.setCategoria("Smart Phone");
    iphone.setFabricante("Apple");
    iphone.setUnidadesEnStock(1000);
    
    Producto laptop_dell = new Producto("P1235","Dell Inspiron", new BigDecimal(700));
    laptop_dell.setDescripcion("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
    laptop_dell.setCategoria("Laptop");
    laptop_dell.setFabricante("Dell");
    laptop_dell.setUnidadesEnStock(1000);
    
    Producto tablet_Nexus = new Producto("P1236","Nexus 7", new BigDecimal(300));
    tablet_Nexus.setDescripcion("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
    tablet_Nexus.setCategoria("Tablet");
    tablet_Nexus.setFabricante("Google");
    tablet_Nexus.setUnidadesEnStock(1000);
    
    listaDeProductos.add(iphone);
    listaDeProductos.add(laptop_dell);
    listaDeProductos.add(tablet_Nexus);
        
    }

    @Override
    public List<Producto> getAllProductos() {
        return listaDeProductos;
    }

	@Override
	public Producto getProductoPorId(String produId) {
		// TODO Auto-generated method stub
		Producto produBuscado = null;
		for (Producto producto : listaDeProductos) {
			if(producto.getIdProducto().equals(produId)) {
				produBuscado=producto;
			}
		}
		return produBuscado;
	}

	@Override
    public List<Producto> getProductosPoCategoria(String categoria) {
       List<Producto> productosEncontrados =  new ArrayList<Producto>();

        for (Producto producto : listaDeProductos) {
            if (producto != null && producto.getCategoria() != null
                    && producto.getCategoria().equalsIgnoreCase(categoria)) {
                productosEncontrados.add(producto);
            }
        }
        return productosEncontrados;
    }
    
    @Override
    public Producto crearProducto(Producto producto) {
        this.listaDeProductos.add(producto);
        return producto;
    }

	@Override
	public Producto modificarProducto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrarProducto(String idProducto) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}
