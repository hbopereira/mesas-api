package com.anp.mesas.base;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class BaseController<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>, SERVICE extends BaseService<ENTITY, REPOSITORY>> {

	@Autowired
	private SERVICE service;
	
	@Autowired
	private REPOSITORY repo;

	@PostMapping
	public ResponseEntity<String> salvar(@RequestBody ENTITY entity) {
		Optional<ENTITY> resultado = service.salvar(entity);
		if (resultado.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(resultado.get().getId().toString());
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<ENTITY>> listarTodos(){
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
}
