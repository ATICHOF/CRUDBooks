package com.core.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.core.models.Book;
import com.core.repo.CRUDBook;


@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private CRUDBook bookRepo;
	
	@Override
	public List<Book> findAll() {
		return (List<Book>) bookRepo.findAll();
	}

	@Override
	public Book findBookById(long id) {
		Optional<Book> optional = bookRepo.findById(id);
		Book book = null;
		if(optional.isPresent()) {
			book = optional.get();
		} else {
			throw new RuntimeException("Book with ID : " + id + " not found!");
		}
		return book;
	}

	@Override
	public void addBook(Book book) {
		this.bookRepo.save(book);
	}

	@Override
	public void deleteBookById(long id) {
		this.bookRepo.deleteById(id);
	}

}
