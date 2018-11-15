package com.renu.s_vs_t.controller;

import java.io.File;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.renu.s_vs_t.repositories.ManageCouchingCenterRepository;
import com.renu.s_vs_t.repositories.ManageInstitutionRepository;
import com.renu.s_vs_t.repositories.ManageInstitutionTypeRepository;
import com.renu.s_vs_t.repositories.ManageJobTypeRepository;
import com.renu.s_vs_t.repositories.ManageTutorRepository;
import com.renu.s_vs_t.utility.FileUploadUtility;

@Controller
@ControllerAdvice
public class AdminController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	@Autowired
	ManageInstitutionTypeRepository manageInstitutionTypeRepository;
	@Autowired
	ManageInstitutionRepository manageInstitutionRepository;
	@Autowired
	ManageJobTypeRepository manageJobTypeRepository;
    @Autowired
    ManageCouchingCenterRepository manageCouchingCenterRepository;
    @Autowired
    ManageTutorRepository manageTutorRepository;
	@RequestMapping(value = "/showManageInstitutionType")
	public String showManageInstitutionType(Model model) {
		LOGGER.info("From class AdminController,method :  showManageInstitutionType() ");
		model.addAttribute("title", "Manage");
		model.addAttribute("manageinstitutiontype", new ManageInstitutionType());
		model.addAttribute("manageinstitution", new ManageInstitution());
		model.addAttribute("managejobtype", new ManageJobType());
		model.addAttribute("jsonurladmin1", "/viewalljobtypes");
		model.addAttribute("jsonurladmin2", "/viewallinstitution");
		
		return "manage";
	}

	
	@RequestMapping(value = "/addJobType", method = { RequestMethod.GET, RequestMethod.POST })
	public String addJobType(
			@Valid @ModelAttribute("managejobtype") ManageJobType manageJobType, BindingResult bindingResult,@ModelAttribute("manageinstitutiontype") ManageInstitutionType manageInstitutionType,
			@ModelAttribute("manageinstitution") ManageInstitution manageInstitution,
			Model model) {
		LOGGER.info("From class AdminController,method :  addJobType()");
		//after adding to see data in manage page
		model.addAttribute("title", "Manage");
		model.addAttribute("manageinstitutiontype", new ManageInstitutionType());
		model.addAttribute("manageinstitution", new ManageInstitution());
		model.addAttribute("managejobtype", new ManageJobType());
		model.addAttribute("jsonurladmin1", "/viewalljobtypes");
		model.addAttribute("jsonurladmin2", "/viewallinstitution");
		
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Your operation has not been completed !!!");
			return "manage";
		}
		if (manageJobType.getId() == null) {
			manageJobTypeRepository.save(manageJobType);
			manageJobType.setId(null);

		} else {
			manageJobTypeRepository.save(manageJobType);
		}

		model.addAttribute("message", "Your operation has been completed !!!");

		return "manage";
	}
	
	
	
	
	
	
	
	
	@RequestMapping(value = "/addInstitutionType", method = { RequestMethod.GET, RequestMethod.POST })
	public String addInstitutionType(
			@Valid @ModelAttribute("manageinstitutiontype") ManageInstitutionType manageInstitutionType,BindingResult bindingResult,
			@ModelAttribute("manageinstitution") ManageInstitution manageInstitution,  @ModelAttribute("managejobtype")ManageJobType manageJobType,
			Model model) {
		LOGGER.info("From class AdminController,method :  addInstitutionType()");
		//after adding to see data in manage page
				model.addAttribute("title", "Manage");
				model.addAttribute("manageinstitutiontype", new ManageInstitutionType());
				model.addAttribute("manageinstitution", new ManageInstitution());
				model.addAttribute("managejobtype", new ManageJobType());
				model.addAttribute("jsonurladmin1", "/viewalljobtypes");
				model.addAttribute("jsonurladmin2", "/viewallinstitution");
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Your operation has not been completed !!!");
			return "manage";
		}
		if (manageInstitutionType.getId() == null) {
			manageInstitutionTypeRepository.save(manageInstitutionType);
			manageInstitutionType.setId(null);

		} else {
			manageInstitutionTypeRepository.save(manageInstitutionType);
		}

		model.addAttribute("message", "Your operation has been completed !!!");

		return "manage";
	}

	@RequestMapping(value = "/addInstitution", method = { RequestMethod.GET, RequestMethod.POST })
	public String addInstitution(@Valid @ModelAttribute("manageinstitution") ManageInstitution manageInstitution,BindingResult bindingResult,
			@ModelAttribute("manageinstitutiontype") ManageInstitutionType manageInstitutionType, @ModelAttribute("managejobtype")ManageJobType manageJobType,
			 Model model) {
		LOGGER.info("From class AdminController,method :  addInstitution()");
		//after adding to see data in manage page
				model.addAttribute("title", "Manage");
				model.addAttribute("manageinstitutiontype", new ManageInstitutionType());
				model.addAttribute("manageinstitution", new ManageInstitution());
				model.addAttribute("managejobtype", new ManageJobType());
				model.addAttribute("jsonurladmin1", "/viewalljobtypes");
				model.addAttribute("jsonurladmin2", "/viewallinstitution");
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", "Your operation has not been completed !!!");
			return "manage";
		}
		if (manageInstitution.getId() == null) {
			manageInstitutionRepository.save(manageInstitution);
			manageInstitution.setId(null);

		} else {
			manageInstitutionRepository.save(manageInstitution);
		}

		model.addAttribute("message", "Your operation has been completed !!!");

		return "manage";
	}

	@ModelAttribute("institutiontype")
	public List<ManageInstitutionType> institutionType() {
		List<ManageInstitutionType> institutionType = manageInstitutionTypeRepository.findAll();
		return institutionType;
	}
	
	
	
	
	
	@RequestMapping(value = "/deleteCouchingByAdmin")
	public String deleteById(@RequestParam("id") long id, Model model) {
		
		model.addAttribute("jsonurl", "/viewallcouching");
		 Collection<SimpleGrantedAuthority>authorities=(Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			
			String role=authorities.toString().replace("[","").replace("]","") ;
			LOGGER.info("From class: AddmeController,method : viewByJobType(), authority : "+role);
			model.addAttribute("role",role );
			
		ManageCouchingCenter manageCouchingCenter=manageCouchingCenterRepository.getById(id);
		
	
	
			String iCodeC=manageCouchingCenter.getiCode();
			
			File iFile=new File(FileUploadUtility.IABS_PATH+iCodeC+".jpg");
		
			if (iFile.exists()) {
				iFile.delete();
			}
			manageCouchingCenterRepository.deleteById(id);
			
			

			model.addAttribute("message", id + "  Number id from couching center has been deleted successfully !!!");
			model.addAttribute("heading", "Available "+manageCouchingCenter.getJobType());
			return "view-allcouching";
			
			
			
			
		
		
	
	}
	
	@RequestMapping(value = "/deleteTutorByAdmin")
	public String deleteByAdmin(@RequestParam("id") long id, Model model) {
		ManageTutor manageTutor=manageTutorRepository.getById(id);
		LOGGER.info("From class AdminController,method : deleteByAdmin() ");
	      model.addAttribute("jsonurl","/viewalltutorByInstitutionName");
	      Collection<SimpleGrantedAuthority>authorities=(Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
			
			String role=authorities.toString().replace("[","").replace("]","") ;
			LOGGER.info("From class: AddmeController,method : viewByJobType(), authority : "+role);
			model.addAttribute("role",role );
			String iCodeT=manageTutor.getiCode();
			File iFile=new File(FileUploadUtility.IABS_PATH+iCodeT+".jpg");
			
			if (iFile.exists()) {
				iFile.delete();
			}
			manageTutorRepository.deleteById(id);


			model.addAttribute("message", id + "  Number id from tutor has been deleted successfully !!!");
			model.addAttribute("heading", "Available Tutor");
			
			return "view-alltutor";
			
			
			
		
		
	
	}
	
	
	

	@RequestMapping(value="/editJobTypeByAdmin",method=RequestMethod.GET)
	public String showEditJobType(@RequestParam("id") long id, Model model) {
		LOGGER.info("From class AdminController,method : showEditJobType() ");
		
		ManageJobType manageJobType=manageJobTypeRepository.getById(id);
           model.addAttribute("managejobtype", manageJobType);
         //after adding to see data in manage page
       	model.addAttribute("title", "Manage");
       	model.addAttribute("manageinstitutiontype", new ManageInstitutionType());
       	model.addAttribute("manageinstitution", new ManageInstitution());
       	model.addAttribute("jsonurladmin1", "/viewalljobtypes");
       	model.addAttribute("jsonurladmin2", "/viewallinstitution");
           return "manage";
		
	}
	
	@RequestMapping(value="/editInstitutionByAdmin",method=RequestMethod.GET)
	public String showEditInstitution(@RequestParam("id") long id, Model model) {
		LOGGER.info("From class AdminController,method : showEditInstitution() ");
		ManageInstitution manageInstitution=manageInstitutionRepository.getById(id);
	
			model.addAttribute("manageinstitution",manageInstitution);
			//after adding to see data in manage page
			model.addAttribute("title", "Manage");
			model.addAttribute("manageinstitutiontype", new ManageInstitutionType());
			model.addAttribute("managejobtype", new ManageJobType());
			model.addAttribute("jsonurladmin1", "/viewalljobtypes");
			model.addAttribute("jsonurladmin2", "/viewallinstitution");
			return "manage";
		
		
	}
	
	
	
	
	
	
	
	

	@RequestMapping(value = "/deleteJobTypeByAdmin")
	public String deleteJobTypeAndInstitutionByAdmin(@RequestParam("id") long id, Model model) {
		LOGGER.info("From class AdminController,method :  deleteJobTypeAndInstitutionByAdmin()");
		model.addAttribute("message",id+" number id from jobType has been deleted successfully !!!");
		//after adding to see data in manage page
				model.addAttribute("title", "Manage");
				model.addAttribute("manageinstitutiontype", new ManageInstitutionType());
				model.addAttribute("manageinstitution", new ManageInstitution());
				model.addAttribute("managejobtype", new ManageJobType());
				model.addAttribute("jsonurladmin1", "/viewalljobtypes");
				model.addAttribute("jsonurladmin2", "/viewallinstitution");
		
		manageJobTypeRepository.deleteById(id);
			return "manage";
		}
	
	
	
	
	
@RequestMapping(value = "/deleteInstitutionByAdmin")
public String deleteAndInstitutionByAdmin(@RequestParam("id") long id, Model model) {
	LOGGER.info("From class AdminController,method :  deleteAndInstitutionByAdmin()");
	model.addAttribute("message",id+" number id from institution has been deleted successfully !!!");
	
	//after adding to see data in manage page
	model.addAttribute("title", "Manage");
	model.addAttribute("manageinstitutiontype", new ManageInstitutionType());
	model.addAttribute("manageinstitution", new ManageInstitution());
	model.addAttribute("managejobtype", new ManageJobType());
	model.addAttribute("jsonurladmin1", "/viewalljobtypes");
	model.addAttribute("jsonurladmin2", "/viewallinstitution");
	
	manageInstitutionRepository.deleteById(id);
		return "manage";
	}



	
	
	
	
	
	
	
	
	
	

}
