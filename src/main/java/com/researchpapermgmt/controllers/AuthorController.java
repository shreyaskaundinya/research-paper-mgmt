package com.researchpapermgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.researchpapermgmt.models.Author;
import com.researchpapermgmt.repositories.AuthorRepository;


@Controller
@RequestMapping("/author/")
public class AuthorController {

	@Autowired
	private AuthorRepository authorRepository;	
	
	@GetMapping("showForm")
	public String showAuthorForm(Author author) {
		return "add-author";
	}
	
	@GetMapping("list")
	public String authors(Model model) {
		model.addAttribute("authors", this.authorRepository.findAll());
		return "index_author";
	}
	
	@PostMapping("add")
	public String addAuthor(@Valid Author author, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-author";
		}
		
		this.authorRepository.save(author);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Author author = this.authorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid author id : " + id));
		
		model.addAttribute("author", author);
		return "update-author";
	}
	
	@PostMapping("update/{id}")
	public String updateAuthor(@PathVariable("id") long id, @Valid Author author, BindingResult result, Model model) {
		if(result.hasErrors()) {
			author.setId(id);
			return "update-author";
		}
		
		// update student
		authorRepository.save(author);
		
		// get all students ( with update)
		model.addAttribute("authors", this.authorRepository.findAll());
		return "index_author";
	}
	
	@GetMapping("delete/{id}")
	public String deleteAuthor(@PathVariable ("id") long id, Model model) {
		
		Author author = this.authorRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid author id : " + id));
		
		this.authorRepository.delete(author);
		model.addAttribute("authors", this.authorRepository.findAll());
		return "index_author";
		
	}
}