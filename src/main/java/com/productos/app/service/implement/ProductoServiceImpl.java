package com.productos.app.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productos.app.entity.ProductoEntity;
import com.productos.app.repository.ProductosRepository;
import com.productos.app.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private final ProductosRepository repository;
	
	private final Environment env;
	
	public ProductoServiceImpl(ProductosRepository repository, Environment env) {
		this.repository = repository;
		this.env = env;
	}

	@Override
	public void saveProducto(ProductoEntity producto) {

	}

	@Override
	public void eleiminarProducto(ProductoEntity producto) {

	}

	@Override
	@Transactional(readOnly = true)
	public List<ProductoEntity> findAll() {
		return ((List<ProductoEntity>) repository.findAll()).stream().map(p ->{
			p.setPort(Integer.valueOf(env.getProperty("local.server.port")));
			return p;
		}).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<ProductoEntity> findById(Long id) {
		
		return repository.findById(id).map(p ->{
			p.setPort(Integer.valueOf(env.getProperty("local.server.port")));
			return p;
		});
	}

}
