package com.researchpapermgmt.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.researchpapermgmt.enums.UserTypes;
import com.researchpapermgmt.models.User;
import com.researchpapermgmt.repositories.UserRepository;
import com.researchpapermgmt.security.SessionUser;
import com.researchpapermgmt.services.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {

	private UserService userService;
	private UserRepository userRepository;

	UserController(UserService userService, UserRepository userRepository) {
		this.userService = userService;
		this.userRepository = userRepository;
	}

	@GetMapping("/")
	public String index() {
		return "index_user";
	}

	// @GetMapping("list")
	// public String users(Model model) {
	// model.addAttribute("users", this.userRepository.findAll());
	// return "index_user";
	// }

	// @PostMapping("add")
	// public String addUser(@Valid User user, BindingResult result, Model model) {
	// if (result.hasErrors()) {
	// return "add-user";
	// }

	// this.userRepository.save(user);
	// return "redirect:list";
	// }

	// @GetMapping("edit/{id}")
	// public String showUpdateForm(@PathVariable("id") long id, Model model) {
	// User currentUser = SessionUser.getUser();

	// if (currentUser == null) {

	// }

	// User user = this.userRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user id : " + id));

	// model.addAttribute("user", user);
	// return "update-user";
	// }

	// @PostMapping("update/{id}")
	// public String updateUser(@PathVariable("id") long id, @Valid User user,
	// BindingResult result, Model model) {
	// if (result.hasErrors()) {
	// user.setId(id);
	// return "update-user";
	// }

	// // update student
	// userRepository.save(user);

	// // get all students ( with update)
	// model.addAttribute("users", this.userRepository.findAll());
	// return "index_user";
	// }

	// @GetMapping("delete/{id}")
	// public String deleteUser(@PathVariable("id") long id, Model model) {

	// User user = this.userRepository.findById(id)
	// .orElseThrow(() -> new IllegalArgumentException("Invalid user id : " + id));

	// this.userRepository.delete(user);
	// model.addAttribute("users", this.userRepository.findAll());
	// return "index_user";

	// }

	@GetMapping("/register")
	public String GetRegisterPage() {
		return "auth/register";
	}

	@PostMapping("/register")
	public String PostReg(Model model, @RequestParam String name, @RequestParam String email,
			@RequestParam String user_type,
			@RequestParam String password) {

		User user = userRepository.findByEmail(email);

		if (user == null) {
			// make user
			User userNew = new User();
			userNew.setName(name);
			userNew.setEmail(email);
			userNew.setPassword(password);

			switch (user_type) {
				case "USER":
					userNew.setUserType(UserTypes.USER);
					break;
				case "CONF_ADMIN":
					userNew.setUserType(UserTypes.CONF_ADMIN);
					break;
				case "PANEL_MEM":
					userNew.setUserType(UserTypes.PANEL_MEMBER);
					break;
				case "AUTHOR":
					userNew.setUserType(UserTypes.AUTHOR);
					break;
				default:
					userNew.setUserType(UserTypes.USER);
			}

			userService.createUser(userNew);

			return "auth/login";
		} else {
			// email exists
			return "auth/register";
		}
	}

	@GetMapping("/login")
	public String GetLoginPage() {
		return "auth/login";
	}

	@PostMapping("/login")
	public String PostLogin(Model model, @RequestParam String email, @RequestParam String password) {
		User user = userRepository.findByEmail(email);

		System.out.println(user);

		if (user == null) {
			return "auth/login";
		}

		if (user.getPassword().equals(password)) {
			SessionUser.setUser(user);
			model.addAttribute("user", user);
			return "index";
		} else {
			return "login";
		}
	}

	@PostMapping("/logout")
	public String PostLogout() {
		SessionUser.setUser(null);
		return "login";
	}
}
