package com.challenge.subwaySandwich.repositories;

import org.springframework.stereotype.Repository;

import com.challenge.subwaySandwich.models.Sandwich;
import com.challenge.subwaySandwich.repositories.base.BaseRepository;

@Repository
public interface SandwichRespository extends BaseRepository<Sandwich, Long> {

}
