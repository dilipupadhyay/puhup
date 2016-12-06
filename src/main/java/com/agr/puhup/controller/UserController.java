package com.agr.puhup.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.agr.puhup.model.User;
import com.agr.puhup.service.SecurityService;
import com.agr.puhup.service.UserService;
import com.agr.puhup.validator.UserValidator;

@RestController
@EnableAutoConfiguration
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public User registration(@RequestBody User user, BindingResult bindingResult) throws Exception {
		String birthDate = user.getBirthDate();
		if (birthDate != null && !birthDate.isEmpty()) {
			DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
			Date dob = (Date) formatter.parse(birthDate);
			user.setDob(dob);
		}
		userValidator.validate(user, bindingResult);
		userService.save(user);
		securityService.autologin(user.getUsername(), user.getPasswordConfirm());
		return user;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public UsernamePasswordAuthenticationToken login(@RequestBody User user) {
		return securityService.login(user);
	}

}