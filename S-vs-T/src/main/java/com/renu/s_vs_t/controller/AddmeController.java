package com.renu.s_vs_t.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
import com.renu.s_vs_t.repositories.ManageCouchingCenterRepository;
import com.renu.s_vs_t.repositories.ManageInstitutionRepository;
import com.renu.s_vs_t.repositories.ManageInstitutionTypeRepository;
import com.renu.s_vs_t.repositories.ManageJobTypeRepository;
import com.renu.s_vs_t.repositories.ManageTutorRepository;
import com.renu.s_vs_t.utility.FileUploadUtility;
import com.renu.s_vs_t.validator.ImageFileForCouchingValidator;
import com.renu.s_vs_t.validator.ImageFileForTutorValidator;
import com.renu.s_vs_t.web.repositories.UserRepository;

@Controller
@ControllerAdvice
public class AddmeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AddmeController.class);
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
	@Autowired
	ManageCouchingCenterRepository manageCouchingCenterRepository;
    public static String jobTypes="";
    public static String institutionType="";
    public static String institutionName="";
    
    
    
	@RequestMapping(value = "/showAddme")
	public String showJobType(Model model) {
		LOGGER.info("From class AddmeController,method : showJobType()");

		model.addAttribute("title", "Addme");
		return "jobtype";
	}

	@ModelAttribute("jobtypes")
	public List<ManageJobType> getJobTypes() {
		LOGGER.info("From class AddmeController,method : getJobTypes()");

		List<ManageJobType> jobTypes = manageJobTypeRepository.findAll();

		return jobTypes;
	}

	@ModelAttribute("allinstitutiontypes")
	public List<ManageInstitutionType> getInstitutionTye() {
		LOGGER.info("From class AddmeController,method : getInstitutionType()");

		List<ManageInstitutionType> institutiontypes = manageInstitutionTypeRepository.findAll();

		return institutiontypes;
	}

	@ModelAttribute("allinstitution")
	public List<ManageInstitution> getInstitution() {
		LOGGER.info("From class AddmeController,method : getInstitution()");

		List<ManageInstitution> institutions = manageInstitutionRepository.findAll();

		return institutions;
	}

	@RequestMapping(value = "/view-by-commonName")
	public String showJobTypeByCommonName(@RequestParam("commonName") String commonName, Model model) {
		LOGGER.info("From class AddmeController,method : showJobTypeByCommonName()");
		if (commonName.equals("tutor")) {
			model.addAttribute("addtutor", new ManageTutor());
			model.addAttribute("title", "Addme");
			return "add-tutor";
		} else {
			model.addAttribute("addcouching", new ManageCouchingCenter());
			model.addAttribute("title", "Addme");
			return "add-couching";
		}

	}

	@RequestMapping(value = "/addTutor", method = RequestMethod.POST)
	public String addTutor(@Valid @ModelAttribute("addtutor") ManageTutor manageTutor, BindingResult bindingResult,
			Model model, HttpServletRequest vRequest, HttpServletRequest iRequest) {
		LOGGER.info("From Class : AddmeController,method : addTutor()");
		LOGGER.info("From Class : AddmeController,method : addTutor(),,Getting id : " + manageTutor.getId());
		if (manageTutor.getId() == null) {

			new ImageFileForTutorValidator().validate(manageTutor, bindingResult);
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Your operation has not been completed successfully !!!");
			return "add-tutor";
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
	     User user = userRepository.findByUsername(email);
		LOGGER.info("Getting email : " + email);
		if (!manageTutor.getWord().equals(user.getWord())) {
			model.addAttribute("message",
					"Your characters or symbol not matching which you added during registration !");
			return "add-tutor";
		}

		if (!manageTutor.getiFile().getOriginalFilename().equals("")) {
			FileUploadUtility.imageUploadFile(iRequest, manageTutor.getiFile(), manageTutor.getiCode());
		}
		if (manageTutor.getId() == null) {
            
			manageTutorRepository.save(manageTutor);
			manageTutor.setId(null);
		} else {
			ManageTutor manageTutorInstitutionType=manageTutorRepository.getByInstitutionType(manageTutor.getInstitutionType());
			ManageTutor manageTutorInstitution=manageTutorRepository.getByInstitution(manageTutor.getInstitution());
			
			if (manageTutorInstitutionType!=null && manageTutorInstitution!=null) {
				
			manageTutorRepository.save(manageTutor);
			}else {
				model.addAttribute("message","Not matching institution type or institution name");
				manageTutor.setId(manageTutor.getId());
				return "add-tutor";
			}

		}

		model.addAttribute("message", "Your operation has been completed successfully !!!");
		return "add-tutor";
	}

	@RequestMapping(value = "/addCouching", method = RequestMethod.POST)
	public String addCouching(@Valid @ModelAttribute("addcouching") ManageCouchingCenter manageCouchingCenter,
			BindingResult bindingResult, Model model, HttpServletRequest vRequest, HttpServletRequest iRequest) {
		LOGGER.info("From Class : AddmeController,method : addCouching()");
		LOGGER.info(
				"From Class : AddmeController,method : addCouching(),,Getting id : " + manageCouchingCenter.getId());
		if (manageCouchingCenter.getId() == null) {

			new ImageFileForCouchingValidator().validate(manageCouchingCenter, bindingResult);
		}

		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Your operation has not been completed successfully !!!");
			return "add-couching";
		}

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		User user = userRepository.findByUsername(email);
		LOGGER.info("Getting email : " + email);
		if (!manageCouchingCenter.getWord().equals(user.getWord())) {
			model.addAttribute("message",
					"Your characters or symbol not matching which you added during registration !");
			return "add-couching";
		}

		if (!manageCouchingCenter.getiFile().getOriginalFilename().equals("")) {
			FileUploadUtility.imageUploadFile(iRequest, manageCouchingCenter.getiFile(),
					manageCouchingCenter.getiCode());
		}
		if (manageCouchingCenter.getId() == null) {

			manageCouchingCenterRepository.save(manageCouchingCenter);
			manageCouchingCenter.setId(null);
		} else {
			manageCouchingCenterRepository.save(manageCouchingCenter);

		}

		model.addAttribute("message", "Your operation has been completed successfully !!!");

		return "add-couching";
	}
	
	
	@RequestMapping(value="/view-by-job-type")
	public String viewByJobType(@RequestParam("jobtype")String jobtype,Model model) {
		LOGGER.info("From Class : AddmeController,method : viewByJobType()");
		model.addAttribute("jsonurl", "/viewallcouching");
		model.addAttribute("heading","Available "+jobtype);
		jobTypes=jobtype;
		List<ManageCouchingCenter>manageCouchingCenter=manageCouchingCenterRepository.findByJobType(jobtype);

		 Collection<SimpleGrantedAuthority>authorities=(Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			
			String role=authorities.toString().replace("[","").replace("]","") ;
			LOGGER.info("From class: AddmeController,method : viewByJobType(), authority : "+role);
			model.addAttribute("role",role );
		
		
		if (manageCouchingCenter.size()!=0) {
			model.addAttribute("jsonurl","/viewallcouching");
			model.addAttribute("heading ", "Available "+jobtype);
			
			return "view-allcouching";
			
		}
		else {
			return "view-allinstitutiontype";
		}
		
		
	
		
		
	}
	

	@RequestMapping(value="/view-by-institution-type",method=RequestMethod.GET)
	public String viewByInstitution(@RequestParam("institutiontype")String institutiontype, Model model) {
		LOGGER.info("From class AddmeController,method method : viewByInstitution() ");
		model.addAttribute("institutionName",manageInstitutionRepository.findByJobType(institutiontype));
		return "view_all_institution_name";
	}
	
	
	@RequestMapping(value="/view-by-instName")
	public String viewTutorByInstitutionName(@RequestParam("institutionName")String institutionName,Model model) {
		LOGGER.info("From class AddmeController,method method : viewTutorByInstitutionName() ");
		model.addAttribute("jsonurl", "/viewalltutorByInstitutionName");
		model.addAttribute("heading","Available teachers");
	    AddmeController.institutionName=institutionName;

		 Collection<SimpleGrantedAuthority>authorities=(Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			
			String role=authorities.toString().replace("[","").replace("]","") ;
			LOGGER.info("From class: AddmeController,method : viewByJobType(), authority : "+role);
			model.addAttribute("role",role );
		
		
		
		return "view-alltutor";
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/showUpdateWordByUser",method=RequestMethod.GET)
	public String showUpdateWordByUser(@RequestParam("id") long id, Model model) {
		LOGGER.info("From Class : AddmeController,method ,method : showUpdateWordByUser()");
		LOGGER.info("Getting id : "+id);
		
		model.addAttribute("id",id);
		return "update-word";
	}
	
	@RequestMapping(value="/update-word")
	public String updateJobTypeByUser(@RequestParam("id") long id,@RequestParam("word") String word,
			Model model) {
		LOGGER.info("From Class : AddmeController,method : updateJobTypeByUser()");
		LOGGER.info("Getting id : "+id);
		LOGGER.info("Getting word : "+word);
		
		
		
		ManageCouchingCenter manageCouchingCenter=manageCouchingCenterRepository.getById(id);
		ManageTutor manageTutor=manageTutorRepository.getById(id);
		if (manageCouchingCenter!=null) {
		
			if (word.equals(manageCouchingCenter.getWord())) {
				model.addAttribute("addcouching", manageCouchingCenter);
				return "add-couching";
			}else {
			model.addAttribute("message","Your word is wrong ! please enter a word which added during registration");	
			model.addAttribute("id",id);
			return "update-word";
			
			}
		}
		else {
			
			if (word.equals(manageTutor.getWord())) {
				model.addAttribute("addtutor", manageTutor);
				return "add-tutor";
			}else {
			model.addAttribute("message","Your word is wrong ! please enter a word which added during registration");	
			model.addAttribute("id",id);
			return "update-word";
			
			}
		}
		
		
		
	}
	
	
	
	
	
	
	@RequestMapping(value="/updateJobType",method=RequestMethod.GET)
	public String showupdateJobType(@RequestParam("id") long id, Model model) {
		LOGGER.info("From class AddmeController,method method : showupdateJobType() ");
		ManageTutor manageTutor=manageTutorRepository.getOne(id);
		ManageCouchingCenter manageCouchingCenter=manageCouchingCenterRepository.getOne(id);
		if (manageCouchingCenter.getJobType()!=null) {
			model.addAttribute("addcouching",manageCouchingCenter);
			return "add-couching";
			
		}
		else {
			model.addAttribute("addtutor",manageTutor);
			return "add-tutor";
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
