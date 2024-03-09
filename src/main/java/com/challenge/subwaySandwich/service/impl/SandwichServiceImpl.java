package com.challenge.subwaySandwich.service.impl;

import org.springframework.stereotype.Service;

import com.challenge.subwaySandwich.models.Sandwich;
import com.challenge.subwaySandwich.repositories.SandwichRespository;
import com.challenge.subwaySandwich.services.SandwichService;
import com.challenge.subwaySandwich.services.base.impl.SimpleAbstractBaseServiceImpl;

@Service
public class SandwichServiceImpl extends SimpleAbstractBaseServiceImpl<Sandwich>
	   implements SandwichService {
	
	private SandwichRespository sandwichRepository;

	public SandwichServiceImpl(SandwichRespository baseRepository) {
        super(baseRepository);
        this.repository = baseRepository;
        this.sandwichRepository = baseRepository;
    }

}
