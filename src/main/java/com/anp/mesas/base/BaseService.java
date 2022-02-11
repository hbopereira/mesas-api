package com.anp.mesas.base;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<ENTITY extends BaseEntity, REPOSITORY extends BaseRepository<ENTITY>> {
	
	@Autowired
	private REPOSITORY repo;

	@Transactional
	public Optional<ENTITY> salvar(ENTITY entity) {
		ENTITY nova = repo.save(entity);
		return Optional.of(nova);
	}


}
