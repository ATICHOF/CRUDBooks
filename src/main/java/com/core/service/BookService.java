package com.core.service;

import java.util.List;

import com.core.models.Book;

public interface BookService {
	List<Book> findAll();
	Book findBookById(long id);
	void addBook(Book book);
	void deleteBookById(long id);
}
