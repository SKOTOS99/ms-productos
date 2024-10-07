package com.productos.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.productos.app.entity.ProductoEntity;

public interface ProductosRepository extends CrudRepository<ProductoEntity, Long>{
	

}
