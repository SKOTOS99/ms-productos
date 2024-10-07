package com.productos.app.controller;

import java.util.List;

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
@RequestMapping("/productos")
public class ProductoController {
	
	private final ProductoService service;
	
	public ProductoController(ProductoService service) {
		this.service = service;
	}
	
	@GetMapping("/listar")
	public List<ProductoEntity> listProductos(){
		return service.findAll();
		
	}
	
	@GetMapping("/listar/{id}")
	public ResponseEntity<ProductoEntity> listarProductoId(@PathVariable Long id) {
		if(service.findById(id).isPresent()) {
			return new ResponseEntity<>(service.findById(id).orElse(null), HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}

}
