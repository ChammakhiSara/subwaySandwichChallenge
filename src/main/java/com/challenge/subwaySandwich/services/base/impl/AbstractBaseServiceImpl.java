package com.challenge.subwaySandwich.services.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;

import com.challenge.subwaySandwich.repositories.base.BaseRepository;
import com.challenge.subwaySandwich.services.base.BaseService;

public abstract class AbstractBaseServiceImpl<T, ID> implements BaseService<T, ID> {

	private static final Logger LOG = LoggerFactory.getLogger(AbstractBaseServiceImpl.class);

	protected Class<T> entityClass;

	protected BaseRepository<T, ID> repository;

	@SuppressWarnings("unchecked")
	protected AbstractBaseServiceImpl(BaseRepository<T, ID> repository) {
		super();
		this.repository = repository;
		this.entityClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@Override
	public Optional<T> findById(ID id) {
		return this.repository.findById(id);
	}

	@Override
	public Collection<T> findAll() {
		return this.repository.findAll();
	}

	@Override
	public T save(T entity) {
		return this.repository.saveAndFlush(entity);
	}

	@Override
	public Collection<T> save(Collection<T> entities) {
		return this.repository.saveAll(entities);
	}

	@Override
	public T update(T entity) {
		return this.repository.save(entity);
	}

	@Override
	public void remove(T entity) {
		this.repository.delete(entity);
	}

	@Override
	public void removeById(ID id) {
		this.repository.deleteById(id);
	}

	@Override
	public void removeAll(Collection<T> entities) {
		this.repository.deleteAll(entities);
	}

	@Override
	public Page<T> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

}
