package br.com.ifrn.workbook.service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService<T, ID extends Serializable> {
	
	@Inject private EntityManager entityManager;
	private JpaRepository<T, ID> repository;
		
	public BaseService(JpaRepository<T, ID> repository) {
		this.repository = repository;
	}	

	public T getById(ID id) {
		return repository.findOne(id);
	}
	
	public List<T> getAll() {
		return repository.findAll();
	}
	
	public T create(T arg) {
		return repository.saveAndFlush(arg);
	}
	
	
	public void delete(ID id) {
		repository.delete(id);
	}
	
	@Transactional
	public T update(T arg) {
		return entityManager.merge(arg);
	}
	
	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
