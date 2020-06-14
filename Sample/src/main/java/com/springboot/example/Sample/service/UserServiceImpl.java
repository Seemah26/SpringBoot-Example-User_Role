package com.springboot.example.Sample.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.example.Sample.Repo.UserRepository;
import com.springboot.example.Sample.model.User;
import com.springboot.example.Sample.util.JwtToken;
import com.springboot.example.Sample.util.PasswordEncryption;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Boolean save(User user) {
		Optional userExist = userRepository.findByEmail(user.getEmail());
		if (!userExist.isPresent()) {
			user.setPassword(PasswordEncryption.PasswordEncoder(user.getPassword()));
			String tokenGen = JwtToken.jwtTokenGenerator(user.getEmail());
			System.out.println("token===>" + tokenGen);
			user.setRoles(user.getRoles());
			userRepository.save(user);
			return true;

		} else {
			System.out.println("user already exist");
			return false;
		}
	}

	@Override
	public Boolean login(String email, String password) {
		Optional<User> userExist = userRepository.findByEmailAndPassword(email,
				PasswordEncryption.PasswordEncoder(password));
		if (userExist.isPresent()) {
			return true;
		}
		return false;
	}

}