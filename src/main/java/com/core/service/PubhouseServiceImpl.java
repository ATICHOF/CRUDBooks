package com.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.models.Pubhouse;
import com.core.repo.CRUDPubhouse;

@Service
public class PubhouseServiceImpl implements PubhouseService {
	
	
	@Autowired
	private CRUDPubhouse pubhouseRepo;
	
	@Override
	public List<Pubhouse> findAll() {
		return (List<Pubhouse>) pubhouseRepo.findAll();
	}

	@Override
	public void addPubhouse(Pubhouse pubhouse) {
		this.pubhouseRepo.save(pubhouse);
	}

	@Override
	public Pubhouse findPubhouseById(long id) {
		Optional<Pubhouse> optional = pubhouseRepo.findById(id);
		Pubhouse pubhouse = null;
		if(optional.isPresent()) {
			pubhouse = optional.get();
		} else {
			throw new RuntimeException("Pubhouse with ID : " + id + " not found!");
		}
		return pubhouse;
	}

	@Override
	public void deletePubhouseById(long id) {
		this.pubhouseRepo.deleteById(id);
	}

}
