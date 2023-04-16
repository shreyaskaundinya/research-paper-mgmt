package com.researchpapermgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.researchpapermgmt.models.Panelmember;
import com.researchpapermgmt.repositories.PanelMemberRepository;



@Controller
@RequestMapping("/panelmember/")
public class PanelMemberController {

	@Autowired
	private PanelMemberRepository panelmemberRepository;	
	
	@GetMapping("showForm")
	public String showPanelMemberForm(Panelmember panelmember) {
		return "add-panelmember";
	}
	
	@GetMapping("list")
	public String panelmembers(Model model) {
		model.addAttribute("panelmembers", this.panelmemberRepository.findAll());
		return "index_panelmember";
	}
	
	@PostMapping("add")
	public String addPanelMember(@Valid @ModelAttribute("panelmember") Panelmember panelmember, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "add-panelmember";
		}
		
		this.panelmemberRepository.save(panelmember);
		return "redirect:list";
	}
	
	
	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable ("id") long id, Model model) {
		Panelmember panelmember = this.panelmemberRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid panelmember id : " + id));
		
		model.addAttribute("panelmember", panelmember);
		return "update-panelmember";
	}
	
	@PostMapping("update/{id}")
	public String updatePanelMember(@PathVariable("id") long id, @Valid Panelmember panelmember, BindingResult result, Model model) {
		if(result.hasErrors()) {
			panelmember.setId(id);
			return "update-panelmember";
		}
		
		// update student
		panelmemberRepository.save(panelmember);
		
		// get all students ( with update)
		model.addAttribute("panelmembers", this.panelmemberRepository.findAll());
		return "index_panelmember";
	}
	
	@GetMapping("delete/{id}")
	public String deletePanelMember(@PathVariable ("id") long id, Model model) {
		
		Panelmember panelmember = this.panelmemberRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid panelmember id : " + id));
		
		this.panelmemberRepository.delete(panelmember);
		model.addAttribute("panelmembers", this.panelmemberRepository.findAll());
		return "index_panelmember";
		
	}
}