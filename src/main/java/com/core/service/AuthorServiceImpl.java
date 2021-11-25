package com.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.models.Author;
import com.core.repo.CRUDAuthor;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	private CRUDAuthor authorRepo;
	
	@Override
	public List<Author> findAll() {
		return (List<Author>) authorRepo.findAll();
	}

	@Override
	public Author findAuthorById(long id) {
		Optional<Author> optional = authorRepo.findById(id);
		Author author = null;
		if(optional.isPresent()) {
			author = optional.get();
		} else {
			throw new RuntimeException("Author with ID : " + id + " not found!");
		}
		return author;
	}

	@Override
	public void addAuthor(Author author) {
		this.authorRepo.save(author);
	}

	@Override
	public void deleteAuthorById(long id) {
		this.authorRepo.deleteById(id);
	}

}
