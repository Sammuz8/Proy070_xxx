package com.curso.domain.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.curso.domain.Producto;
@Repository
@Qualifier("JPAProductosRepository")
@Transactional(propagation = Propagation.SUPPORTS)
public class JPAProductoRepository implements ProductoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public JPAProductoRepository() {
		System.out.println("... instanciando JPAProductoRepository");
	}

	@Override
	
	public List<Producto> getAllProductos() {
		Query query = entityManager.createNamedQuery("Producto.findAll");
		return query.getResultList();
	}

	@Override
	public Producto getProductoPorId(String idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}

	
	@Override
	public List<Producto> getProductosPoCategoria(String categoria) {
		Query query = entityManager.createNamedQuery("Producto.findByCategoria");
		query.setParameter("categoria", categoria);
		return query.getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Producto crearProducto(Producto producto) {
		entityManager.persist(producto);
		return producto;
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public Producto modificarProducto(Producto producto) {
		Producto pBD = entityManager.find(Producto.class, producto.getIdProducto());
		entityManager.merge(producto);
		return pBD;
	}
	
	@Override
	@Transactional(propagation = Propagation.MANDATORY)
	public void borrarProducto(String idProducto) {
		Producto pBD = entityManager.find(Producto.class, idProducto);
		entityManager.remove(pBD);
	}

}
