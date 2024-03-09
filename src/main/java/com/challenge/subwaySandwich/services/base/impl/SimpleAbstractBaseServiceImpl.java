package com.challenge.subwaySandwich.services.base.impl;

import com.challenge.subwaySandwich.repositories.base.BaseRepository;
import com.challenge.subwaySandwich.services.base.SimpleBaseService;

public abstract class SimpleAbstractBaseServiceImpl<T> extends AbstractBaseServiceImpl<T, Long>
		implements SimpleBaseService<T> {

	protected SimpleAbstractBaseServiceImpl(BaseRepository<T, Long> repository) {
		super(repository);
	}
}
