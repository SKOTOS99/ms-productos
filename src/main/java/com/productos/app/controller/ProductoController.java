package com.productos.app.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productos.app.entity.ProductoEntity;
import com.productos.app.service.ProductoService;

@RestController
@RequestMapping("/api")
public class ProductoController {
	
	private final ProductoService service;
	
	public ProductoController(ProductoService service) {
		this.service = service;
	}
	
	@GetMapping("/productos/listar")
	public List<ProductoEntity> listProductos(){
		return service.findAll();
		
	}
	
	@GetMapping("/productos/listar/{id}")
	public ResponseEntity<ProductoEntity> listarProductoId(@PathVariable Long id) throws InterruptedException {
		if(id==11) {
			throw new IllegalStateException("producto no encontrado");
		}
		if(id==7) {
			TimeUnit.SECONDS.sleep(5L);
		}
		if(service.findById(id).isPresent()) {
			return new ResponseEntity<>(service.findById(id).orElse(null), HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}

}
