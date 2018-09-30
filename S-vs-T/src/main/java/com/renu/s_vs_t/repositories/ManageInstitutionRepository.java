package com.renu.s_vs_t.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.renu.s_vs_t.models.ManageInstitution;

public interface ManageInstitutionRepository extends JpaRepository<ManageInstitution, Long>,JpaSpecificationExecutor<ManageInstitution>{
	 //delete by id
	public ManageInstitution getById(Long id);
	
	//get by institution name
	public ManageInstitution getByInstitutionName(String institutionName);
	
	//find by category
			public static final String institutionType="FROM ManageInstitution where institutionType=:institutionType";
		        	@Query(institutionType)
		        List<ManageInstitution> findByJobType(@Param("institutionType")String institutionType);




}
