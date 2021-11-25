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
import com.core.models.Page;
import com.core.service.AuthorService;
import com.core.service.BookService;
import com.core.service.PageService;
@Controller
public class PageController {
	@Autowired
	private PageService pageService;
	
	@Autowired
	private BookService bookService ;
	
	@GetMapping("/pages")
	public String viewBooks(Model model) {
		model.addAttribute("listPage", pageService.findAll());
		return "pages";
	}

	@PostMapping("/savepage")
	public String savePage(@ModelAttribute("page") Page page) {
		pageService.addPage(page);
		return "redirect:/pages";
	}
	
	@GetMapping("/addpage")
	public String addPage(Model model) {
		List<Book> listBook = bookService.findAll();
		Page page = new Page();
		Book book = new Book();
		model.addAttribute("page", page);
		model.addAttribute("listBook", listBook ) ;
		return "addpage";
	}
	
	@GetMapping("/updatepage/{id}")
	public String updatePage(@PathVariable(value="id") long id, Model model) {
		List<Book> listBook = bookService.findAll();
		Page page = pageService.findPageById(id);
		Book book = new Book();
		model.addAttribute("page", page);
		model.addAttribute("listBook", listBook ) ;
		return "updatepage";
	}
	
	@GetMapping("/deletepage/{id}")
	public String deletePage(@PathVariable(value="id") long id, Model model) {
		this.pageService.deletePageById(id);
		return "redirect:/pages";
	}
}
