package com.business.repositories;

import org.springframework.data.repository.CrudRepository;

import com.business.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findUserByUemail(String email);
}
