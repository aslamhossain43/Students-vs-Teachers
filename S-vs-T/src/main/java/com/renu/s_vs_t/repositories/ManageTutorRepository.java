package com.renu.s_vs_t.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.s_vs_t.models.ManageTutor;

public interface ManageTutorRepository extends JpaRepository<ManageTutor, Long>,JpaSpecificationExecutor<ManageTutor>{
	//find by id
	public ManageTutor getById(Long id);
	//find by getByInstitutionType
	public ManageTutor getByInstitutionType(String institutionType);
	//find by getByInstitution
		public ManageTutor getByInstitution(String institution);
		
	//find by category
			public static final String jobType="FROM ManageTutor where jobType=:jobType";
		        	@Query(jobType)
		        List<ManageTutor> findByJobType(@Param("jobType")String jobType);
		        	
		        	
		        	

		        	//find by category
					public static final String institutionName="FROM ManageTutor where institution=:institutionName";
				        	@Query(institutionName)
				        List<ManageTutor> findByInstitutionName(@Param("institutionName")String institutionName);

	
		        	
		        	
		        	
		        	
		        	
		        	
		        	
}
