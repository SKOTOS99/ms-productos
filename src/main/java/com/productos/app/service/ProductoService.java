package com.productos.app.service;

import java.util.List;
import java.util.Optional;

import com.productos.app.entity.ProductoEntity;

public interface ProductoService {

	
	public void saveProducto(ProductoEntity producto);
	
	public void eleiminarProducto(ProductoEntity producto);
	
	public List<ProductoEntity> findAll();
	
	Optional<ProductoEntity> findById(Long id);
	
}
