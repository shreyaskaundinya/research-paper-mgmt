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

import com.researchpapermgmt.models.Confadmin;
import com.researchpapermgmt.repositories.ConfAdminRepository;


@Controller
@RequestMapping("/confadmin/")
public class ConfAdminController {

	@Autowired
	private ConfAdminRepository confadminRepository;	
	
	@GetMapping("showForm")
	public String showConfAdminForm(Confadmin confadmin) {
		return "add-confadmin";
	}
	
	@GetMapping("list")
	public String confadmins(Model model) {
		model.addAttribute("confadmins", this.confadminRepository.findAll());
		return "index_confadmin";
	}
	
	@PostMapping("add")
	public String addConfAdmin(@Valid Confadmin confadmin, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-confadmin";
		}
		
		this.confadminRepository.save(confadmin);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Confadmin confadmin = this.confadminRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid confadmin id : " + id));
		
		model.addAttribute("confadmin", confadmin);
		return "update-confadmin";
	}
	
	@PostMapping("update/{id}")
	public String updateConfAdmin(@PathVariable("id") long id, @Valid Confadmin confadmin, BindingResult result, Model model) {
		if(result.hasErrors()) {
			confadmin.setId(id);
			return "update-confadmin";
		}
		
		// update student
		confadminRepository.save(confadmin);
		
		// get all students ( with update)
		model.addAttribute("confadmins", this.confadminRepository.findAll());
		return "index_confadmin";
	}
	
	@GetMapping("delete/{id}")
	public String deleteAuthor(@PathVariable ("id") long id, Model model) {
		
		Confadmin confadmin = this.confadminRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid confadmin id : " + id));
		
		this.confadminRepository.delete(confadmin);
		model.addAttribute("confadmins", this.confadminRepository.findAll());
		return "index_confadmin";
		
	}
}
