package com.renu.s_vs_t.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value="/")
	public String showHome(Model model) {
		LOGGER.info("From class HomeController,method : showHome() ");
		model.addAttribute("title", "Home");
		return "home";
	}
}