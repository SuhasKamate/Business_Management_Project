package com.business.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.business.entities.Admin;
import com.business.repositories.AdminRepository;

@Service
public class AdminServices {

	private final AdminRepository adminRepository;
	private final PasswordEncoder passwordEncoder;

	public AdminServices(AdminRepository adminRepository, PasswordEncoder passwordEncoder) {
		this.adminRepository = adminRepository;
		this.passwordEncoder = passwordEncoder;
	}

	// Get All Admins
	public List<Admin> getAll() {
		return (List<Admin>) this.adminRepository.findAll();
	}

	// Get Single Admin
	public Admin getAdmin(int id) {
		return this.adminRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No admin found with id: " + id));
	}

	// Update Admin — load the managed row, mutate it, then save
	public void update(Admin admin, int id) {
		Admin existing = getAdmin(id);
		existing.setAdminName(admin.getAdminName());
		existing.setAdminEmail(admin.getAdminEmail());
		existing.setAdminNumber(admin.getAdminNumber());
		if (admin.getAdminPassword() != null && !admin.getAdminPassword().isBlank()) {
			existing.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));
		}
		this.adminRepository.save(existing);
	}

	// Delete Admin
	public void delete(int id) {
		this.adminRepository.deleteById(id);
	}

	// Add Admin — hash the password before persisting
	public void addAdmin(Admin admin) {
		if (admin.getAdminPassword() == null || admin.getAdminPassword().isBlank()) {
			admin.setAdminPassword("1234"); // default, change on first login
		}
		admin.setAdminPassword(passwordEncoder.encode(admin.getAdminPassword()));
		this.adminRepository.save(admin);
	}
}
