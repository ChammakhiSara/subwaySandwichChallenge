package com.challenge.subwaySandwich.repositories.base;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Auditable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.history.RevisionRepository;

@NoRepositoryBean
public interface BaseRepository<E, ID> extends JpaRepository<E, ID>, RevisionRepository<E, ID, Integer> {

	Page<E> findAll(Pageable pageble);

	List<E> findAll(Sort sort);

	List<E> findAll();

	Optional<E> findById(Long id);

	void deleteById(Long id);

}
