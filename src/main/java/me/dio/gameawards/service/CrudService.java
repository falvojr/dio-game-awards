package me.dio.gameawards.service;

import java.util.List;

public interface CrudService<T> {
	
	List<T> findAll();

	T findById(Long id);

	void insert(T entidade);

	void update(Long id, T entidade);

	void delete(Long id);
}
