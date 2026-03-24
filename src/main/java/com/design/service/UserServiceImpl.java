package com.design.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.design.entity.User;
import com.design.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

		private UserRepository userRepository;
		public UserServiceImpl(UserRepository userRepository){
			this.userRepository=userRepository;
		}	
		@Override
		public void saveUsers(User user) {
			userRepository.save(user);
		}		
		@Override
		public List<User> getAllUsersList(){
			return userRepository.findAll();
		}		
		public User getUserById(Long id) {
			return userRepository.findById(id).orElse(null);
		}		
		public void deleteUser(Long id) {
			userRepository.deleteById(id);
		}
}
