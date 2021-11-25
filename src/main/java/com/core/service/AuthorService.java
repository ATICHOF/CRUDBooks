package com.core.service;

import java.util.List;

import com.core.models.Author;

public interface AuthorService {
	List<Author> findAll();
	Author findAuthorById(long id);
	void addAuthor(Author author);
	void deleteAuthorById(long id);
}
