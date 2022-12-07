package me.dio.gameawards.service.impl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import me.dio.gameawards.domain.BaseEntity;
import me.dio.gameawards.service.CrudService;
import me.dio.gameawards.service.exception.BusinessException;
import me.dio.gameawards.service.exception.NoContentException;

public abstract class BaseCrudService<E extends BaseEntity, T extends JpaRepository<E, Long>> implements CrudService<E> {

	protected T repository;

	public BaseCrudService(T repository) {
		this.repository = repository;
	}

	@Override
	public void insert(E entidade) {
		this.repository.save(entidade);
	}

	@Override
	public List<E> findAll() {
		return this.repository.findAll();
	}

	@Override
	public E findById(Long id) {
		return this.repository.findById(id).orElseThrow(() -> new NoContentException());
	}

	@Override
	public void update(Long id, E entidade) {
		E entidadeBd = this.findById(id);
		if (entidadeBd.getId().equals(entidade.getId())) {
			this.repository.save(entidade);
		} else {
			throw new BusinessException("Os identificadores para alteração são divergentes.");
		}
	}

	@Override
	public void delete(Long id) {
		E entidadeBd = this.findById(id);
		this.repository.delete(entidadeBd);
	}

}