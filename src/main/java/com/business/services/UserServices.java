package com.business.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.business.entities.User;
import com.business.repositories.UserRepository;

@Service
public class UserServices {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	public UserServices(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// Get All Users
	public List<User> getAllUser() {
		return (List<User>) this.userRepository.findAll();
	}

	// Get Single User
	public User getUser(int id) {
		return this.userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No user found with id: " + id));
	}

	// Get Single User By Email
	public User getUserByEmail(String email) {
		return this.userRepository.findUserByUemail(email);
	}

	// Update User — hash a new password if one was supplied
	public void updateUser(User user, int id) {
		User existing = getUser(id);
		existing.setUname(user.getUname());
		existing.setUemail(user.getUemail());
		existing.setUnumber(user.getUnumber());
		if (user.getUpassword() != null && !user.getUpassword().isBlank()) {
			existing.setUpassword(passwordEncoder.encode(user.getUpassword()));
		}
		this.userRepository.save(existing);
	}

	// Delete single User
	public void deleteUser(int id) {
		this.userRepository.deleteById(id);
	}

	// Add User — hash the password before persisting
	public void addUser(User user) {
		if (user.getUpassword() == null || user.getUpassword().isBlank()) {
			user.setUpassword("2330"); // default, change on first login
		}
		user.setUpassword(passwordEncoder.encode(user.getUpassword()));
		this.userRepository.save(user);
	}
}
