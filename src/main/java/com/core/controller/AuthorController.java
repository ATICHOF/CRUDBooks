package com.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.core.models.Author;
import com.core.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService authorService;
	
	@GetMapping("/authors")
	public String viewAuthors(Model model) {
		model.addAttribute("listAuthor", authorService.findAll());
		return "crud/authors/authors";
	}

	@PostMapping("/saveauthor")
	public String saveAuthor(@ModelAttribute("author") Author author) {
		authorService.addAuthor(author);
		return "redirect:/authors";
	}
	
	@GetMapping("/addauthor")
	public String addAuthor(Model model) {
		Author author = new Author();
		model.addAttribute("author", author);
		return "crud/authors/addauthor";
	}
	
	@GetMapping("/updateauthor/{id}")
	public String updateAuthor(@PathVariable(value="id") long id, Model model) {
		Author author = authorService.findAuthorById(id);
		model.addAttribute("author", author);
		return "crud/authors/updateauthor";
	}
	
	@GetMapping("/deleteauthor/{id}")
	public String deleteAuthor(@PathVariable(value="id") long id, Model model) {
		this.authorService.deleteAuthorById(id);
		return "redirect:/authors";
	}
}
