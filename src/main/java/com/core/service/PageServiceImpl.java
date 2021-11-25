package com.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.models.Page;
import com.core.repo.CRUDPage;

@Service
public class PageServiceImpl implements PageService {

	@Autowired
	private CRUDPage pageRepo;
	
	@Override
	public List<Page> findAll() {
		return (List<Page>) pageRepo.findAll();
	}

	@Override
	public void addPage(Page page) {
		this.pageRepo.save(page);
	}

	@Override
	public Page findPageById(long id) {
		Optional<Page> optional = pageRepo.findById(id);
		Page page = null;
		if(optional.isPresent()) {
			page = optional.get();
		} else {
			throw new RuntimeException("Page with ID : " + id + " not found!");
		}
		return page;
	}

	@Override
	public void deletePageById(long id) {
		this.pageRepo.deleteById(id);
	}

}
