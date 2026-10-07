package com.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.business.entities.User;
import com.business.services.UserServices;

@Controller
public class UserController {

	private final UserServices userServices;

	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}

	@PostMapping("/addingUser")
	public String addUser(@ModelAttribute User user) {
		this.userServices.addUser(user);
		return "redirect:/admin/services";
	}

	@PostMapping("/updatingUser/{id}")
	public String updateUser(@ModelAttribute User user, @PathVariable("id") int id) {
		this.userServices.updateUser(user, id);
		return "redirect:/admin/services";
	}

	@PostMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		this.userServices.deleteUser(id);
		return "redirect:/admin/services";
	}
}
