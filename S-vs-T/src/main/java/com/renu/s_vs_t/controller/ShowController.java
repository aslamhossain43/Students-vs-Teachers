package com.renu.s_vs_t.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowController {
private static final Logger LOGGER=LoggerFactory.getLogger(ShowController.class);

@RequestMapping(value="/about")
public String showAbout(Model model) {
	LOGGER.info("From class ShowController,method : showAbout()");
	model.addAttribute("title", "About");
return "about";	
}
		
	
@RequestMapping(value="/lookteachers")
public String showLookteachers(Model model) {
	LOGGER.info("From class ShowController,method : showLookteachers()");
	model.addAttribute("title", "Look-teachers");
return "look-teachers";	
}
	
	
	
	
	
}
