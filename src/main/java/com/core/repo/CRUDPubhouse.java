package com.core.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.core.models.Pubhouse;

@Repository
public interface CRUDPubhouse extends CrudRepository<Pubhouse, Long> {

}
