package com.renu.s_vs_t.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.renu.s_vs_t.models.ManageCouchingCenter;
import com.renu.s_vs_t.models.ManageInstitution;
import com.renu.s_vs_t.models.ManageInstitutionType;
import com.renu.s_vs_t.models.ManageJobType;
import com.renu.s_vs_t.models.ManageTutor;
import com.renu.s_vs_t.models.User;
import com.renu.s_vs_t.repositories.ManageInstitutionRepository;
import com.renu.s_vs_t.repositories.ManageInstitutionTypeRepository;
import com.renu.s_vs_t.repositories.ManageJobTypeRepository;
import com.renu.s_vs_t.repositories.ManageTutorRepository;
import com.renu.s_vs_t.utility.FileUploadUtility;
import com.renu.s_vs_t.validator.ImageFileValidator;
import com.renu.s_vs_t.web.repositories.UserRepository;

@Controller
@ControllerAdvice
public class AddmeController {
private static final Logger LOGGER=LoggerFactory.getLogger(AddmeController.class);
@Autowired
ManageJobTypeRepository manageJobTypeRepository;
@Autowired
ManageInstitutionTypeRepository manageInstitutionTypeRepository;
@Autowired
ManageInstitutionRepository manageInstitutionRepository;
@Autowired
UserRepository userRepository;
@Autowired
ManageTutorRepository manageTutorRepository;

@RequestMapping(value="/showAddme")
public String showJobType(Model model) {
	LOGGER.info("From class AddmeController,method : showJobType()");
	
	
	return "jobtype";
}
@ModelAttribute("jobtypes")
public List<ManageJobType>getJobTypes(){
	LOGGER.info("From class AddmeController,method : getJobTypes()");
	
	List<ManageJobType>jobTypes=manageJobTypeRepository.findAll();
	
	return jobTypes;
}


@ModelAttribute("allinstitutiontypes")
public List<ManageInstitutionType>getInstitutionTye(){
	LOGGER.info("From class AddmeController,method : getInstitutionType()");
	
	List<ManageInstitutionType>institutiontypes=manageInstitutionTypeRepository.findAll();
	
	return institutiontypes;
}



@ModelAttribute("allinstitution")
public List<ManageInstitution>getInstitution(){
	LOGGER.info("From class AddmeController,method : getInstitution()");
	
	List<ManageInstitution>institutions=manageInstitutionRepository.findAll();
	
	return institutions;
}






@RequestMapping(value="/view-by-commonName")
public String showJobTypeByCommonName(@RequestParam("commonName")String commonName,Model model) {
	LOGGER.info("From class AddmeController,method : showJobTypeByCommonName()");
	if (commonName.equals("tutor")) {
		model.addAttribute("addtutor",new ManageTutor());

		return "add-tutor";
	}else {
		model.addAttribute("addcouching", new ManageCouchingCenter());
		
		return "add-couching";
	}
	
}


@RequestMapping(value="/addTutor",method=RequestMethod.POST)
public String addTutor(@Valid @ModelAttribute("addtutor") ManageTutor manageTutor,BindingResult bindingResult,
	    Model model,HttpServletRequest vRequest,HttpServletRequest iRequest) {
	LOGGER.info("From Class : AddmeController,method : addTutor()");
	LOGGER.info("From Class : AddmeController,method : addTutor(),,Getting id : "+manageTutor.getId());
	   if (manageTutor.getId()==null) {
		
		
	    new ImageFileValidator().validate(manageTutor, bindingResult);
	   }
	
	if (bindingResult.hasErrors()) {
		model.addAttribute("message", "Your operation has not been completed successfully !!!");
		return "add-tutor";
	}

	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	String email=authentication.getName();
	User user=userRepository.findByUsername(email);
	LOGGER.info("Getting email : "+email);
	if (!manageTutor.getWord().equals(user.getWord())) {
		model.addAttribute("message","Your characters or symbol not matching which you added during registration !");
	return "add-tutor";
	}

	if (!manageTutor.getiFile().getOriginalFilename().equals("")) {
		FileUploadUtility.imageUploadFile(iRequest, manageTutor.getiFile(),manageTutor.getiCode());
	}
	if (manageTutor.getId()==null) {
		
		manageTutorRepository.save(manageTutor);	
		manageTutor.setId(null);
	}else {
		manageTutorRepository.save(manageTutor);
		
	}
	
	model.addAttribute("message", "Your operation has been completed successfully !!!");
	
	return "add-tutor";
}







}
