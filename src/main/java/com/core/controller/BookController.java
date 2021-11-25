package com.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.core.models.Author;
import com.core.models.Book;
import com.core.models.Pubhouse;
import com.core.service.AuthorService;
import com.core.service.BookService;
import com.core.service.PubhouseService;

@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	@Autowired
	private AuthorService authorService ;
	
	@Autowired
	private PubhouseService pubhouseService ;
	
	@GetMapping("/books")
	public String viewBooks(Model model) {
		model.addAttribute("listBook", bookService.findAll());
		return "crud/books/books";
	}
	@PostMapping("/savebook")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.addBook(book);
		return "redirect:/books";
	}
	
	@GetMapping("/addbook")
	public String addBook(Model model) {
		List<Author> listAuthor = authorService.findAll();
		List<Pubhouse> listPubhouse = pubhouseService.findAll();
		Book book = new Book();
		Author author = new Author() ;
		Pubhouse pubhouse = new Pubhouse() ;
		model.addAttribute("book", book);
		model.addAttribute("listAuthor", listAuthor ) ;
		model.addAttribute("listPubhouse", listPubhouse ) ;
		return "crud/books/addbook";
	}
	
	@GetMapping("/updatebook/{id}")
	public String updateBook(@PathVariable(value="id") long id, Model model) {
		Book book = bookService.findBookById(id);
		List<Author> listAuthor = authorService.findAll();
		List<Pubhouse> listPubhouse = pubhouseService.findAll();
		Author author = new Author() ;
		Pubhouse pubhouse = new Pubhouse() ;
		model.addAttribute("book", book);
		model.addAttribute("listAuthor", listAuthor ) ;
		model.addAttribute("listPubhouse", listPubhouse ) ;
		return "crud/books/updatebook";
	}
	
	@GetMapping("/deletebook/{id}")
	public String deleteBook(@PathVariable(value="id") long id, Model model) {
		this.bookService.deleteBookById(id);
		return "redirect:/books";
	}
}
