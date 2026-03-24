package com.design.service;

import java.util.List;
import com.design.entity.User;

public interface UserService {
	
	void saveUsers(User user);
	List<User> getAllUsersList();
	User getUserById(Long id);
	void deleteUser(Long id);
}
