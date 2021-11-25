package com.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.core.models.Pubhouse;
import com.core.service.PubhouseService;


@Controller
public class PubhouseController {
	
	@Autowired
	private PubhouseService pubhouseService;

	
	@GetMapping("/pubhouses")
	public String viewPubhouses(Model model) {
		model.addAttribute("listPubhouse", pubhouseService.findAll());
		return "pubhouses";
	}

	@PostMapping("/savepubhouse")
	public String savePubhouse(@ModelAttribute("pubhouse") Pubhouse pubhouse) {
		pubhouseService.addPubhouse(pubhouse);
		return "redirect:/pubhouses";
	}
	
	@GetMapping("/addpubhouse")
	public String addPubhouse(Model model) {
		Pubhouse pubhouse = new Pubhouse();
		model.addAttribute("pubhouse", pubhouse);
		return "addpubhouse";
	}
	
	@GetMapping("/updatepubhouse/{id}")
	public String updatePubhouse(@PathVariable(value="id") long id, Model model) {
		Pubhouse pubhouse = pubhouseService.findPubhouseById(id);
		model.addAttribute("pubhouse", pubhouse);
		return "updatepubhouse";
	}
	
	@GetMapping("/deletepubhouse/{id}")
	public String deletePubhouse(@PathVariable(value="id") long id, Model model) {
		this.pubhouseService.deletePubhouseById(id);
		return "redirect:/pubhouses";
	}
}