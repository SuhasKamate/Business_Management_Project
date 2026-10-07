package com.business.security;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.business.entities.Admin;
import com.business.entities.User;
import com.business.repositories.AdminRepository;
import com.business.repositories.UserRepository;

/**
 * Loads either an Admin (ROLE_ADMIN) or a User (ROLE_USER) by email so both
 * can authenticate through the same Spring Security form login.
 */
@Service
public class AppUserDetailsService implements UserDetailsService {

	private final AdminRepository adminRepository;
	private final UserRepository userRepository;

	public AppUserDetailsService(AdminRepository adminRepository, UserRepository userRepository) {
		this.adminRepository = adminRepository;
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Admin admin = adminRepository.findByAdminEmail(email);
		if (admin != null) {
			return new org.springframework.security.core.userdetails.User(
					admin.getAdminEmail(),
					admin.getAdminPassword(),
					Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN")));
		}

		User user = userRepository.findUserByUemail(email);
		if (user != null) {
			return new org.springframework.security.core.userdetails.User(
					user.getUemail(),
					user.getUpassword(),
					Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
		}

		throw new UsernameNotFoundException("No account found for email: " + email);
	}
}
