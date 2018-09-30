package com.renu.s_vs_t.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renu.s_vs_t.models.ManageCouchingCenter;
import com.renu.s_vs_t.models.ManageTutor;
import com.renu.s_vs_t.repositories.ManageCouchingCenterRepository;
import com.renu.s_vs_t.repositories.ManageTutorRepository;

@Controller
public class ShowController {
private static final Logger LOGGER=LoggerFactory.getLogger(ShowController.class);
@Autowired
ManageCouchingCenterRepository manageCouchingCenterRepository;
@Autowired
ManageTutorRepository manageTutorRepository;
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
	
	



@RequestMapping(value="/singleViewForCouching")
public String singleViewForCouching(@RequestParam("id")Long id,Model model) {
	LOGGER.info("From class ShowController ,method : singleViewForCouching()");
	ManageCouchingCenter manageCouchingCenter=manageCouchingCenterRepository.getById(id);
	model.addAttribute("sc", manageCouchingCenter);
	
	return "single_for_couching";
}


@RequestMapping(value="/singleViewForTutor")
public String singleViewForTutor(@RequestParam("id")Long id,Model model) {
	LOGGER.info("From class ShowController ,method : singleViewForTutor()");
	ManageTutor manageTutor=manageTutorRepository.getById(id);
	model.addAttribute("st", manageTutor);
	
	return "single_for_tutor";
}

	
	
	
}
