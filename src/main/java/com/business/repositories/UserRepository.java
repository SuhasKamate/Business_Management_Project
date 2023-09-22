package com.business.repositories;

import org.springframework.data.repository.CrudRepository;

import com.business.entities.Admin;
import com.business.entities.User;

public interface UserRepository extends CrudRepository<User,Integer>
{
public User findUserByUemail(String email);
}
