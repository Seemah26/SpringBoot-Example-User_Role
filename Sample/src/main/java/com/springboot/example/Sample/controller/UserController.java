package com.springboot.example.Sample.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.Sample.model.Login;
import com.springboot.example.Sample.model.User;
import com.springboot.example.Sample.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/Register")
	public ResponseEntity<?> userRegister(@RequestBody User userDetail,HttpServletResponse response) {	
		Boolean userExist = userService.save(userDetail);
	if (userExist) {
		System.out.println("Registartion successfull");
		return new ResponseEntity<>(HttpStatus.OK);
	} else	{
		System.out.println("Registartion failed");
		return new ResponseEntity<String>("User Already exist",HttpStatus.BAD_REQUEST);
	}
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> userLogin(@RequestBody Login login,HttpServletRequest request, HttpServletResponse response) {
		Boolean userExist = userService.login(login.getEmail(), login.getPassword());
	if (userExist) {
		System.out.println("login successfull");
		return new ResponseEntity<>(HttpStatus.OK);
	} else	{
		System.out.println("login failed");
		return new ResponseEntity<String>("{Invalid Credentials}",HttpStatus.BAD_REQUEST);
	}
	}	
}
