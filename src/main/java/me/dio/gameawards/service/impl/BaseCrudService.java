package me.dio.gameawards.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.gameawards.domain.BaseEntity;
import me.dio.gameawards.service.CrudService;
import me.dio.gameawards.service.exception.NegocioException;
import me.dio.gameawards.service.exception.SemResultadoException;

public abstract class BaseCrudService<T extends BaseEntity> implements CrudService<T> {
	
	protected JpaRepository<T, Long> repository;

    public BaseCrudService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }
	
	@Override
	public void inserir(T entidade) {
		this.repository.save(entidade);
	}

	@Override
	public List<T> buscarTodos() {
		return this.repository.findAll();
	}

	@Override
	public T buscarUm(Long id) {
		return this.repository.findById(id).orElseThrow(() -> new SemResultadoException());
	}

	@Override
	public void alterar(Long id, T entidade) {
		T entidadeBd = this.buscarUm(id);
		if (entidadeBd.getId().equals(entidade.getId())) {
			this.repository.save(entidade);
		} else {
			throw new NegocioException("Os identificadores para altera��o s�o divergentes.");
		}
	}

	@Override
	public void excluir(Long id) {
		T entidadeBd = this.buscarUm(id);
		this.repository.delete(entidadeBd);
	}

}