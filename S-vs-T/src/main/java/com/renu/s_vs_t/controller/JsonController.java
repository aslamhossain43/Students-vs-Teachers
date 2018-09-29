package com.renu.s_vs_t.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.renu.s_vs_t.models.ManageCouchingCenter;
import com.renu.s_vs_t.models.ManageTutor;
import com.renu.s_vs_t.repositories.ManageCouchingCenterRepository;
import com.renu.s_vs_t.repositories.ManageTutorRepository;

@Controller
public class JsonController {
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonController.class);
	@Autowired
	ManageCouchingCenterRepository manageCouchingCenterRepository;
	@Autowired
	ManageTutorRepository manageTutorRepository;

	@RequestMapping(value = "/viewalltutorByInstitutionName")
	@ResponseBody
	public List<ManageTutor> getAllTutor() {
		LOGGER.info("From class JsonController,method : getAllTutor()");
		return manageTutorRepository.findByInstitutionName(AddmeController.institutionName);

	}

	@RequestMapping(value = "/viewallcouching")
	@ResponseBody
	public List<ManageCouchingCenter> getAllCouching() {
		LOGGER.info("From class JsonController,method : getAllCouching()");
		List<ManageCouchingCenter> manageCouchingCenters = manageCouchingCenterRepository
				.findByJobType(AddmeController.jobTypes);

		return manageCouchingCenters;

	}

}
