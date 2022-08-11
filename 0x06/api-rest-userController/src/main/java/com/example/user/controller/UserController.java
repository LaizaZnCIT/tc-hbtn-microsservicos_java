package com.example.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.exception.CPFException;
import com.example.user.exception.UserIdException;
import com.example.user.exception.UserNameException;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@GetMapping("/user-id/{id}")
	public String findUserById(@PathVariable int id) {
		if(id > 0 && id < 100) {
			return "You have entered valid ID";
		} else {
			throw new UserIdException();
		}
	}
	
	@GetMapping("/user-name/{userName}")
	public String findUserByName(@PathVariable String userName) {
		if(userName.length() > 3 && userName.length() < 15) {
			return "You have entered valid USERNAME";
		} else {
			throw new UserNameException();
		}
	}
	
	@GetMapping("/user-cpf/{cpf}")
	public String findUserByCPF(@PathVariable String cpf) {
		boolean isCPFValid = isCPF(cpf);
		if(isCPFValid) {
			return "You have entered valid CPF";
		} else {
			throw new CPFException();
		}
	}
	
	public boolean isCPF(String CPF) {
		if(CPF.length() > 3 && CPF.length() < 15) {
			return true;
		} else {
			return false;
		}
	}
}
