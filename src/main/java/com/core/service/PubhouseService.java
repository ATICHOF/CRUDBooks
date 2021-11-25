package com.core.service;

import java.util.List;

import com.core.models.Pubhouse;


public interface PubhouseService {
	List<Pubhouse> findAll();
	Pubhouse findPubhouseById(long id);
	void addPubhouse(Pubhouse pubhouse);
	void deletePubhouseById(long id);

}
