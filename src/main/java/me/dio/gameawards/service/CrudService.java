package me.dio.gameawards.service;

import java.util.List;

public interface CrudService<T> {
	
	List<T> buscarTodos();

	T buscarUm(Long id);

	void inserir(T entidade);

	void alterar(Long id, T entidade);

	void excluir(Long id);
}
