package com.kodnest.tunehub.serviceimpl;

import com.kodnest.tunehub.entity.User;

public interface UserService {

	public String addUser(User user);

	public boolean emailExists(String email) ;

	public boolean validateUser(String email, String password);

	public String getRole(String email) ;
}