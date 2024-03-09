package com.challenge.subwaySandwich.services.base;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.history.Revision;
import org.springframework.data.history.Revisions;

public interface BaseService<T, ID> {
	final static String DESC = "DESC";

	Optional<T> findById(ID id);

	Collection<T> findAll();

	T save(T entity);

	Collection<T> save(Collection<T> entities);

	T update(T entity);

	void remove(T entity);

	void removeById(ID id);

	void removeAll(Collection<T> entities);

	Page<T> findAll(Pageable pageable);

	default Pageable getPageable(Integer page, Integer size, String sortAttribute, String sortDirection) {
		Sort sort = null;
		if (size == null) {
			size = 10;
		}
		if (sortAttribute != null && !sortAttribute.isEmpty()) {
			sort = Sort.by(sortAttribute);
			if (sortDirection != null && sortDirection.toUpperCase().equals(DESC)) {
				sort = sort.descending();
			} else {
				sort = sort.ascending();
			}
		}
		if (page == null) {
			page = 0;
		}
		Pageable pageable = null;
		if (sort != null) {
			pageable = PageRequest.of(page >= 1 ? page - 1 : 0, size > 0 ? size : 12, sort);
		} else {
			pageable = PageRequest.of(page >= 1 ? page - 1 : 0, size > 0 ? size : 12);
		}
		return pageable;
	}

	default Sort getSort(String sortAttribute, String sortDirection) {
		Sort sort = null;
		if (sortAttribute != null && !sortAttribute.isEmpty()) {
			sort = Sort.by(sortAttribute);
			if (sortDirection != null && sortDirection.toUpperCase().equals(DESC)) {
				sort = sort.descending();
			} else {
				sort = sort.ascending();
			}
		}
		return sort;
	}

}