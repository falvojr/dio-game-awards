package me.dio.gameawards.service;

import java.util.List;

public interface CrudService<E> {
	
	List<E> findAll();

	E findById(Long id);

	void insert(E entity);

	void update(Long id, E entity);

	void delete(Long id);
}
