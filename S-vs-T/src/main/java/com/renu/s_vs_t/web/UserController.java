package com.renu.s_vs_t.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.renu.s_vs_t.models.User;
import com.renu.s_vs_t.repositories.User_Repository;
import com.renu.s_vs_t.web.services.SecurityService;
import com.renu.s_vs_t.web.services.UserService;


@Controller
@ControllerAdvice
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private User_Repository user_Repository;
	@Autowired
	UserService userService;

	@Autowired
	SecurityService securityService;


	@RequestMapping("/login")
	public String login(Model model, String error, String logout, HttpServletRequest request) {
		LOGGER.info("From class UserController,method : login()");
		if (logout != null) {
			model.addAttribute("logout", "You have been logged out successfully.");
		}

		model.addAttribute("title", "Login");

		return "login";
	}

	@RequestMapping(value = "/loginSuccess")
	public String loginSuccess(Model model, String username) {
		LOGGER.info("From class UserController,method : loginSuccess()");
		model.addAttribute("message", "Login has been completed successfully.");

		return "home";
	}

	@RequestMapping(value = "/loginError")
	public String loginError(Model model, String username) {
		LOGGER.info("From class UserController,method : loginError()");
		model.addAttribute("error", "Your username and password is invalid.");
		model.addAttribute("title", "Login");

		return "login";
	}

	@RequestMapping(value = "/aaslamaadminssignup")
	public String adminRegistration(Model model) {
		model.addAttribute("userform", new User());
		model.addAttribute("title", "Registration");
		return "admin-signup";
	}

	@RequestMapping(value = "/adminregistration", method = { RequestMethod.POST, RequestMethod.GET })
	public String adminRegistration(@Valid @ModelAttribute("userform") User userform, BindingResult bindingResult,
			Model model, String[] roles) {
		LOGGER.info("From class : WebController, method : registration()");
		LOGGER.info("Getting password : " + userform.getPassword());
		LOGGER.info("Getting confirmPassword : " + userform.getConfirmPassword());

		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Your Registration has not been completed successfully !!!");
			return "admin-signup";
		}

		String password = userform.getPassword();
		if (!userform.getPassword().equals(userform.getConfirmPassword())) {
			model.addAttribute("message", "Your password and confirm password is not equal !!! ");
			return "admin-signup";
		}

		// can't retrieve values by digits
		User user1 = user_Repository.getByUsername(userform.getUsername());

		if (user1 != null) {
			model.addAttribute("message", "This email is already exist !!!");
			return "admin-signup";

		} else {

			userService.saveUser(userform, roles);
			securityService.autologin(userform.getUsername(), password);
			model.addAttribute("message", "Your Registration has been completed successfully !!!");
			return "admin-signup";
		}

	}

	@RequestMapping(value = "/showsignup")
	public String showSignup(Model model) {
		LOGGER.info("From class : UserController, method : showSignup()");
		model.addAttribute("userform", new User());
		model.addAttribute("title", "Signup");
		return "signup";
	}

	@RequestMapping(value = "/signup", method = { RequestMethod.POST, RequestMethod.GET })
	public String signup(@Valid @ModelAttribute("userform") User userform, BindingResult bindingResult,
			Model model, String[] roles) {
		LOGGER.info("From class : UserController, method : signup()");
		LOGGER.info("Getting password : " + userform.getPassword());
		LOGGER.info("Getting confirmPassword : " + userform.getConfirmPassword());

		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Your Registration has not been completed successfully !!!");
			return "signup";
		}

		String password = userform.getPassword();
		if (!userform.getPassword().equals(userform.getConfirmPassword())) {
			model.addAttribute("message", "Your password and confirm password is not equal !!! ");
			return "signup";
		}
		// can't retrieve values by digits
		User user1 = user_Repository.getByUsername(userform.getUsername());

		if (user1 != null) {
			model.addAttribute("message", "This email is already exist !!!");
			return "signup";

		}

		else {

			userService.saveUser(userform, roles);
			securityService.autologin(userform.getUsername(), password);
			model.addAttribute("message", "Your Registration has been completed successfully !!!");
			return "signup";
		}

	}

	

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response, Model model) {
		LOGGER.info("From class UserController,method : logout()");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}

		model.addAttribute("message", "Logout has been completed successfully");
		return "redirect:/login?logout";
	}
	
	
	
	@ModelAttribute("authorityObject")
	public User getEmail() {
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String email=authentication.getName();
		LOGGER.info(" From class UserController ,method : getEmail()");
		User user=user_Repository.getByUsername(email);
		
		return user;
		
	}
	
	
	
	
	

}
