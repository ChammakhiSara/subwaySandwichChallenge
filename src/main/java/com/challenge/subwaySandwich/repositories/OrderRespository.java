package com.challenge.subwaySandwich.repositories;

import org.springframework.stereotype.Repository;

import com.challenge.subwaySandwich.models.Order;
import com.challenge.subwaySandwich.repositories.base.BaseRepository;

@Repository
public interface OrderRespository extends BaseRepository<Order, Long> {

}
