package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.curso.domain.Producto;
import com.curso.domain.repository.ProductoRepository;

@Service
public class PedidoServiceImp implements PedidoService {

	@Autowired
	// @Qualifier("InMemoryProductosRepository")
	@Qualifier("JPAProductosRepository")
	private ProductoRepository productoRepositorio;

	@Override
	public void generarPedido(String idProdu, int cantidad) {
		// TODO Auto-generated method stub
		if (idProdu == null) {
			throw new IllegalArgumentException("Debe introducir un id de producto");
		}
		Producto produ = productoRepositorio.getProductoPorId(idProdu);
		if (produ == null) {
			throw new IllegalArgumentException("No Existe tal producto");
		}

		long stock = produ.getUnidadesEnStock();
		if (cantidad <= 0) {
			throw new IllegalArgumentException("Cantidad debe ser un numero entero positivo");
		}
		if ((stock - cantidad) < 0) {
			throw new IllegalArgumentException("Fuera de stock, no dispone tantos productos");
		}
		produ.setUnidadesEnStock(stock - cantidad);

	}

}
