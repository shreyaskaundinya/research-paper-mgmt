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

import com.researchpapermgmt.models.User;
import com.researchpapermgmt.repositories.UserRepository;
import com.researchpapermgmt.security.SessionUser;

@Controller
@RequestMapping("/user/")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String index() {
		return "index_user";
	}

	@GetMapping("showForm")
	public String showUserForm(User user) {
		return "add-user";
	}

	@GetMapping("list")
	public String users(Model model) {
		model.addAttribute("users", this.userRepository.findAll());
		return "index_user";
	}

	@PostMapping("add")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		this.userRepository.save(user);
		return "redirect:list";
	}

	@GetMapping("edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		User currentUser = SessionUser.getUser();

		if (currentUser == null) {

		}

		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user id : " + id));

		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		// update student
		userRepository.save(user);

		// get all students ( with update)
		model.addAttribute("users", this.userRepository.findAll());
		return "index_user";
	}

	@GetMapping("delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {

		User user = this.userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user id : " + id));

		this.userRepository.delete(user);
		model.addAttribute("users", this.userRepository.findAll());
		return "index_user";

	}

	@GetMapping("/login")
	public String GetLoginPage() {
		return "login";
	}
}
