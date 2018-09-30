package com.renu.s_vs_t.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.renu.s_vs_t.models.ManageCouchingCenter;
import com.renu.s_vs_t.repositories.ManageCouchingCenterRepository;


@Controller
public class GoogleMapController {
	private static final Logger LOGGER=LoggerFactory.getLogger(GoogleMapController.class);
	@Autowired
	ManageCouchingCenterRepository manageCouchingCenterRepository;
	
	@RequestMapping("/map")
	private String showMap(@RequestParam("id")long id,Model model) {
		LOGGER.info(" From class : GoogleMapController, Method : showMap");
		LOGGER.info("Getting id : "+id);
		ManageCouchingCenter manageCouchingCenter=manageCouchingCenterRepository.getById(id);
		
		model.addAttribute("mapData", manageCouchingCenter);
		return "google-map";
	}
	
	
}
